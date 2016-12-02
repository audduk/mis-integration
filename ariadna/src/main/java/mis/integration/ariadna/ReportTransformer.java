package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ReportGroup;
import mis.lis.report.Order;
import mis.lis.report.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class ReportTransformer {
  public List<Report> transformToReport(Observation observation) {
    final List<Report> result = new ArrayList<>();
    if (observation.getReportGroups() == null)
      return result;
    for (ReportGroup group : observation.getReportGroups()) {
      final Report e = new Report();
      e.setOrder(new Order());
      e.getOrder().setExternalID("1");
      result.add(e);
      final Report e1 = new Report();
      e1.setOrder(new Order());
      e1.getOrder().setExternalID("2");
      result.add(e1);
    }
    return result;
  }
}
