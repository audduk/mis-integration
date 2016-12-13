package mis.integration.ariadna;

import mis.lis.report.Report;
import mis.lis.report.Result;

import java.util.Calendar;

/**
 * Получение кода услуги для протокола исследований
 */
public class ServiceCodeFinder {
  public String getCode(Report report) {
    for (Result.Service service : report.getAdditional().getLis().getResult().getService())
      return service.getCode();
    return String.format("xxx-%d", Calendar.getInstance().getTimeInMillis());
  }
}
