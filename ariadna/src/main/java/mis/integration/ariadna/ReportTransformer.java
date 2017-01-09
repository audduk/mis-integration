package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ObservationResult;
import mis.integration.ariadna.data.OrderItem;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.ariadna.exceptions.ReportDataException;
import mis.lis.report.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class ReportTransformer {
  private static Logger logger = LoggerFactory.getLogger(ReportTransformer.class);

  public Report transformToReport(Observation observation, ReportGroup group) throws ReportDataException {
    final List<OrderItem> orderItems = observation.getOrderItems();
    try {
      if (orderItems == null || orderItems.isEmpty())
        throw new ReportDataException("Отсутствует содержание заказа (orderItems)", observation);
      final Report report = generateReport(observation);
      fillReport(report, group, orderItems);
      return report;
    } catch (ReportDataException ex) {
      final String message = String.format("Отчет ЛИ %s/%d. %s", observation.getMisOrderID(), observation.getId(), ex.getMessage());
      throw new ReportDataException(message, ex.getObservation() != null ? ex.getObservation() : observation);
    }
  }

  private static void fillReport(Report report, ReportGroup group, List<OrderItem> orderItems) throws ReportDataException {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd hh:mm:ss YYYY");

    final Info info = report.getInfo();
    info.setPhysician(group.getVerifierName());
    info.setVerified(group.getVerifierID().toString());
    info.setDate(dateFormat.format(group.getFinishDate().getTime()));
    info.setLogin(group.getVerifierID().toString()); //в соответствии с MIS-17916 может содержать Id врача

    final Report.Additional.Lis lis = report.getAdditional().getLis();
    final Result.Service service = new Result.Service();
    lis.getResult().getService().add(service);
    Long serviceId = null;
    final List<Result.Service.Indicator> indicatorList = service.getIndicator();
    for (ObservationResult observationResult : group.getResults()) {
      if ("H".equals(observationResult.getHeaderMark())) //пропускаем элементы-заголовки
        continue;
      if (observationResult.getOrderedServiceID() == 0L) {
        logger.error("Отсутствует привязка к услуге. {}", group.getResultDescription());
        continue;
      }
      if (serviceId == null) {
        serviceId = observationResult.getOrderedServiceID();
        final OrderItem orderItem = getOrderItemById(orderItems, serviceId);
        service.setCode(orderItem.getServiceCode());
        lis.setServiceName(orderItem.getService());
      }
      final Result.Service.Indicator indicator = new Result.Service.Indicator();
      indicator.setName(observationResult.getMeasurementName());
      indicator.setValue(observationResult.getResultValue());
      indicator.setUnits(observationResult.getUnit());
      indicator.setMax(observationResult.getNormMax());
      indicator.setMin(observationResult.getNormMin());
      indicatorList.add(indicator);
    }
    if (indicatorList.isEmpty())
      throw new ReportDataException(String.format("%s. Отсутствуют результаты исследований", group.getResultDescription()), null);
  }

  private static OrderItem getOrderItemById(List<OrderItem> orderItems, Long id) throws ReportDataException {
    for (OrderItem orderItem : orderItems)
      if (orderItem.getServiceID().equals(id))
        return orderItem;
    throw new ReportDataException(String.format("Отсутствует идентификатор услуги %d", id), null);
  }

  /**
   * Создание и наполнение протокола МИС на основе объекта {@link Observation} (без результатов тестов!)
   * Выполняется для одного заказа однократно, далее клонируется
   */
  private static Report generateReport(Observation observation) throws ReportDataException {
    //конструируем объект протокола
    final Report report = new Report();
    report.setOrder(new Order());
    report.setInfo(new Info());
    report.setAttachments(new Attachments());
    report.setAdditional(new Report.Additional());
    report.getAdditional().setStatdata(new Report.Additional.Statdata());//далее не заполняем
    report.getAdditional().setLis(new Report.Additional.Lis());
    report.setPrintedReport(new Report.PrintedReport());

    final Order order = report.getOrder();
    order.setExternalID(observation.getMisOrderID());
    order.setInternalID(observation.getMisOrderID()); //заглушка (МИС не использует, но по протоколу обязательно)
    order.setPatientGuid(observation.getPatient().getMisId());

    final Report.Additional.Lis lis = report.getAdditional().getLis();
    lis.setResult(new Result());

    return report;
  }

}
