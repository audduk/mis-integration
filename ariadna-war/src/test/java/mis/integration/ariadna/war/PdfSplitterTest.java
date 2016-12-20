package mis.integration.ariadna.war;

import mis.integration.ariadna.file.PdfSplitter;
import org.junit.Test;
import org.springframework.data.util.Pair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PdfSplitterTest {
  @Test
  public void testReportUrlEmpty() throws UnsupportedEncodingException {
    PdfSplitter splitter = new PdfSplitter("192.168.1.1", "8080/birt", "095671");
    String url = splitter.reportUrl(new ArrayList<Pair<String, String>>());
    System.out.println(url);
  }

  @Test
  public void testReportUrl() throws UnsupportedEncodingException {
    PdfSplitter splitter = new PdfSplitter("192.168.1.1", "8080/birt", "095671");
    ArrayList<Pair<String, String>> params = new ArrayList<>();
    params.add(Pair.of("param1", "param1"));
    params.add(Pair.of("param2", "Параметр 2"));
    String url = splitter.reportUrl(params);
    System.out.println(url);
  }
}
