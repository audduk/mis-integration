package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ReportGroup;
import mis.lis.prescription.PrescriptionDTO;
import mis.lis.report.Report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class Transformer {
  public List<Report> transformToReport(Observation observation) {
    final List<Report> result = new ArrayList<>();
    if (observation.getReportGroups() == null)
      return result;
    for (ReportGroup group : observation.getReportGroups()) {
      result.add(new Report());
      result.add(new Report());
    }
    return result;
  }

  public Observation transformToObservation(PrescriptionDTO prescription) {
    final Observation result = new Observation();
    result.setId(Calendar.getInstance().getTimeInMillis());
    return result;
  }
}
