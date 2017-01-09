package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.ariadna.data.ReportRoot;
import mis.integration.ariadna.exceptions.ReportDataException;
import mis.lis.report.Report;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;
import java.util.List;

/**
 * Тестирование трансформера
 */
public class ReportTransformerTest extends AbstractAriadnaTest {

  private Unmarshaller unmarshaller;
  private Marshaller reportMarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(ReportRoot.class);
    unmarshaller = jc.createUnmarshaller();

    jc = JAXBContext.newInstance(Report.class);
    reportMarshaller = jc.createMarshaller();
  }

  private List<Observation> getFileObservations(String path) throws JAXBException {
    ReportRoot report = (ReportRoot) unmarshaller.unmarshal(getResourceAsStream(path));
    return report.getObservations();
  }

  @Test
  public void testTransformation() throws ReportDataException, JAXBException {
    ReportTransformer transformer = new ReportTransformer();
    final List<Observation> observations = getFileObservations("reports/15350001.xml");
    for (Observation observation : observations) {
      for (ReportGroup reportGroup : observation.getReportGroups()) {
        final Report misReport = transformer.transformToReport(observation, reportGroup);
        final StringWriter writer= new StringWriter();
        reportMarshaller.marshal(misReport, writer);
        System.out.println(writer.toString());
      }
    }
  }

  @Test(expected = ReportDataException.class)
  public void testBadReports() throws ReportDataException, JAXBException {
    ReportTransformer transformer = new ReportTransformer();
    final List<Observation> observations = getFileObservations("reports/1-10-59.xml");
    for (Observation observation : observations)
      for (ReportGroup reportGroup : observation.getReportGroups())
        transformer.transformToReport(observation, reportGroup);
  }
}
