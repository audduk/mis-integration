package mis.integration.ariadna.file;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.Patient;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.utils.Pair;
import mis.lis.report.Report;
import mis.lis.report.Result;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Выполняет трансформацию сообщения в коллекцию двух элементов: String и byte[] (pdf)
 */
public class PdfSplitter extends AbstractTransformer {
  private static Logger logger = LoggerFactory.getLogger(PdfSplitter.class);

  private String host;
  private String port;
  private String filename;

  public PdfSplitter(String host, String port, String filename) {
    this.host = host;
    this.port = port;
    this.filename = filename;
    logger.debug(String.format("PdfSplitter created \t%s:%s\t%s", host, port, filename));
  }

  @Override
  protected List<Object> doTransform(Message<?> message) throws Exception {
    final List<Object> result = new ArrayList<>(2);
    result.add(message.getPayload());
    if (filename != null && !"xxx".equals(filename)) {
      byte[] pdf = generatePdf(
          (Observation) message.getHeaders().get("observation"),
          (ReportGroup) message.getHeaders().get("reportGroup"),
          (Report) message.getHeaders().get("report"));
      if (pdf != null)
        result.add(pdf);
    }
    return result;
  }

  public String reportUrl(List<Pair<String, String>> params) throws UnsupportedEncodingException {
    String paramsString = "";
    for (Pair<String, String> param : params) {
      String value = param.getSecond();
      if (value != null)
        value = URLEncoder.encode(value, "UTF-8");
      paramsString += String.format("&%s=%s", param.getFirst(), value);
    }
    return String.format("http://%s:%s/output?__report=%s.rptdesign%s&__format=pdf", host, port, filename, paramsString);
  }

  public byte[] generatePdf(Observation observation, ReportGroup group, Report report) throws UnsupportedEncodingException {
    final String url = reportUrl(generateParams(observation, group, report));
    logger.debug(String.format("Отчет ЛИ %s/%d. Generate report: %s", observation.getMisOrderID(), observation.getId(), url));
    final GetMethod method = new GetMethod(url);
    try {
      HttpClient client = new HttpClient();
      int statusCode = client.executeMethod(method);
      if (statusCode != HttpStatus.SC_OK)
        throw new RuntimeException("HTTP method failed: " + method.getStatusLine());
      if (!method.getResponseHeader("Content-Type").getValue().contains("application/pdf"))
        throw new RuntimeException("Ошибка при создании отчета");
      return method.getResponseBody();
    } catch (Exception e) {
      logger.error(String.format("Отчет ЛИ %s/%d. Ошибка при выгрузкe отчета: %s", observation.getMisOrderID(), observation.getId(), e.getMessage()));
      e.printStackTrace();
    } finally {
      method.releaseConnection();
    }
    return null;
  }

  private List<Pair<String, String>> generateParams(Observation observation, ReportGroup group, Report report) {
    final List<Pair<String, String>> params = new ArrayList<>(4);

    params.add(Pair.of("doctor", report.getInfo().getPhysician()));
    if (!isEmpty(observation.getMisOrderID()))
      params.add(Pair.of("recordId", observation.getMisOrderID())); //идентификатор назначения Prescription (внутренний идентификатор заказа в МИС)
    final Patient patient = observation.getPatient();
    params.add(Pair.of("patient", patient.getFamilyName().toUpperCase() + " " + patient.getGivenName().toUpperCase() + " " + patient.getMiddleName().toUpperCase()));
    params.add(Pair.of("date", formanDate(group.getFinishDate())));
    final Report.Additional.Lis lis = report.getAdditional().getLis();
    params.add(Pair.of("service", lis.getServiceName()));
    String resultString = "";
    for (Result.Service service : lis.getResult().getService()) {
      for (Result.Service.Indicator indicator : service.getIndicator()) {
        if (!resultString.isEmpty())
          resultString += ",";
        resultString += String.format("{\"r1\":\"%s\",\"r2\":\"%s %s\",\"r3\":\"%s - %s\"}",
            indicator.getName(), get(indicator.getValue()), get(indicator.getUnits()),
            get(indicator.getMin()), get(indicator.getMax()));
      }
    }
    params.add(Pair.of("results", String.format("[%s]", resultString)));

    return params;
  }

  private static String formanDate(Calendar date){
    if (date == null)
      return "-";
    final SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
    return format.format(date.getTime());
  }

  private static String get(String value) {
    return value != null? value : "";
  }
}
