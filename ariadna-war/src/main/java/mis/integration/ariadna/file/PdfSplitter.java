package mis.integration.ariadna.file;

import mis.integration.ariadna.data.Observation;
import mis.lis.report.Result;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Выполняет трансформацию сообщения в коллекцию двух элементов: String и byte[] (pdf)
 */
public class PdfSplitter extends AbstractTransformer {
  @Override
  protected List<Object> doTransform(Message<?> message) throws Exception {
    final List<Object> result = new ArrayList<>(2);
    result.add(message.getPayload());
    result.add(generatePdf(
        (Observation) message.getHeaders().get("observation"),
        (Result) message.getHeaders().get("result")));
    return result;
  }

  private byte[] generatePdf(Observation observation, Result result) {
    assert observation != null;
    assert result != null;
    return "xxx".getBytes(Charset.forName("UTF-8"));
  }
}
