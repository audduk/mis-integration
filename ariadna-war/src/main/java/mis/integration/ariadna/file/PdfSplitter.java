package mis.integration.ariadna.file;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.Patient;
import mis.lis.report.Result;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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
    logger.info(String.format("PdfSplitter created \t%s:%s\t%s", host, port, filename));
  }

  @Override
  protected List<Object> doTransform(Message<?> message) throws Exception {
    final List<Object> result = new ArrayList<>(2);
    result.add(message.getPayload());
    if (filename != null && !"xxx".equals(filename)) {
      byte[] pdf = generatePdf(
          (Observation) message.getHeaders().get("observation"),
          (Result) message.getHeaders().get("result"));
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

  public byte[] generatePdf(Observation observation, Result result) throws UnsupportedEncodingException {
    final String url = reportUrl(generateParams(observation));//"http://localhost:8082/output?__report=report.rptdesign&__format=html";
    final GetMethod method = new GetMethod(url);
    try {
      HttpClient client = new HttpClient();
      int statusCode = client.executeMethod(method);
      if (statusCode == HttpStatus.SC_OK)
        return method.getResponseBody();
      logger.error("HTTP method failed: " + method.getStatusLine());
    } catch (IOException e) {
      logger.error("Ошибка при выгрузкe отчета: " + e.getMessage());
      e.printStackTrace();
    } finally {
      method.releaseConnection();
    }
    return null;
  }

  private List<Pair<String, String>> generateParams(Observation observation) {
    List<Pair<String, String>> result = new ArrayList<>(4);

    final Patient patient = observation.getPatient();
    result.add(Pair.of("person", patient.getFamilyName() + " " + patient.getGivenName() + " " + patient.getMiddleName()));
    result.add(Pair.of("gender", patient.getGender()));

    return result;
  }
}
