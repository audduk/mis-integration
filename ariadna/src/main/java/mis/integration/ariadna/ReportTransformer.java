package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ObservationResult;
import mis.integration.ariadna.data.OrderItem;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.ariadna.exceptions.ReportDataException;
import mis.lis.report.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class ReportTransformer {
  public Report transformToReport(Observation observation, ReportGroup group) throws ReportDataException {
    final List<OrderItem> orderItems = observation.getOrderItems();
    if (orderItems == null || orderItems.isEmpty())
      throw new ReportDataException("Отсутствует содержание заказа (orderItems)", observation);
    final Report report = generateReport(observation);
    fillReport(report, group, orderItems);
    return report;
  }

  private static void fillReport(Report report, ReportGroup group, List<OrderItem> orderItems) throws ReportDataException {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd hh:mm:ss YYYY");

    final Info info = report.getInfo();
    info.setPhysician(group.getVerifierName());
    info.setVerified((group.getVerifierID() != null)? group.getVerifierID().toString() : null);
    info.setDate(dateFormat.format(group.getFinishDate().getTime()));
    info.setLogin("vrach_lis"); //логин по умолчанию "Врач лаборатории", будет в дальнейшем расширено (по необходимости)

    final Report.Additional.Lis lis = report.getAdditional().getLis();
    final Result.Service service = new Result.Service();
    lis.getResult().getService().add(service);
    Long serviceId = null;
    final List<Result.Service.Indicator> indicatorList = service.getIndicator();
    for (ObservationResult observationResult : group.getResults()) {
      if ("H".equals(observationResult.getHeaderMark())) //пропускаем элементы-заголовки
        continue;
      if (serviceId == null) {
        serviceId = observationResult.getOrderedServiceID();
        service.setCode(getOrderCodeById(orderItems, serviceId));
      }
      final Result.Service.Indicator indicator = new Result.Service.Indicator();
      indicator.setName(observationResult.getMeasurementName());
      indicator.setValue(observationResult.getResultValue());
      indicator.setUnits(observationResult.getUnit());
      indicator.setMax(observationResult.getNormMax());
      indicator.setMin(observationResult.getNormMin());
      indicatorList.add(indicator);
    }
  }

  private static String getOrderCodeById(List<OrderItem> orderItems, Long id) throws ReportDataException {
    for (OrderItem orderItem : orderItems)
      if (orderItem.getServiceID().equals(id))
        return orderItem.getServiceCode();
    throw new ReportDataException("Некорректно задан идентификатор услуги", null);
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
