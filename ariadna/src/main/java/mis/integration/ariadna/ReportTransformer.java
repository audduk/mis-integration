package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ObservationResult;
import mis.integration.ariadna.data.OrderItem;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.ariadna.exceptions.ReportDataException;
import mis.lis.report.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class ReportTransformer {
  public List<Report> transformToReport(Observation observation) throws ReportDataException {
    final List<Report> result = new ArrayList<>();
    if (observation.getReportGroups() == null)
      throw new ReportDataException("Не заполнено поле Observation.ReportsGroup", observation);
    for (ReportGroup group : observation.getReportGroups()) {
      final Report report = generateReport(observation);
      fillReport(report, group);
      result.add(report);
    }
    return result;
  }

  private static void fillReport(Report report, ReportGroup group) {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd hh:mm:ss YYYY");

    final Info info = report.getInfo();
    info.setPhysician(group.getVerifierName());
    info.setVerified("1");
    info.setDate(dateFormat.format(group.getFinishDate().getTime()));
    info.setLogin(group.getVerifierID().toString());//todo добавить определение логина, важно

    final Report.Additional.Lis lis = report.getAdditional().getLis();
    final List<Result.Service> serviceList = lis.getResult().getService();
    assert serviceList.size() == 1; //ожидается ровно один элемент (см. реализацию generateReport)
    final List<Result.Service.Indicator> indicatorList = serviceList.get(0).getIndicator();
    for (ObservationResult observationResult : group.getResults()) {
      if ("H".equals(observationResult.getHeaderMark())) //пропускаем элементы-заголовки
        continue;
      final Result.Service.Indicator indicator = new Result.Service.Indicator();
      indicator.setName(observationResult.getMeasurementName());
      indicator.setValue(observationResult.getResultValue());
      indicator.setUnits(observationResult.getUnit());
      indicator.setMax(observationResult.getNormMax());
      indicator.setMin(observationResult.getNormMin());
      indicatorList.add(indicator);
    }
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
    order.setPatientGuid(observation.getPatient().getMisId()); //todo преобразование idPatient в guidPatient (запрос БД)

    final Report.Additional.Lis lis = report.getAdditional().getLis();
    lis.setResult(new Result());
    final List<OrderItem> orderItems = observation.getOrderItems();
    if (orderItems == null || orderItems.isEmpty())
      throw new ReportDataException("Отсутствует содержание заказа (orderItems)", observation);
    if (orderItems.size() > 1) //todo разобраться с этим - может ли быть несколько, как между ними делятся группы (сделан запрос производителю)
      throw new ReportDataException("Ожидается orderItems.size = 1", observation);
    for (OrderItem orderItem : orderItems) {
      final Result.Service service = new Result.Service();
      service.setCode(orderItem.getServiceCode());
      lis.getResult().getService().add(service);
    }

    return report;
  }

}
