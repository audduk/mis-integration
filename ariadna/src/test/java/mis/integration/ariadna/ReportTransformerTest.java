package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ReportRoot;
import mis.integration.ariadna.data.RequestRoot;
import mis.integration.ariadna.exceptions.PrescriptionDataException;
import mis.integration.ariadna.exceptions.ReportDataException;
import mis.lis.prescription.LabPrescriptionDTO;
import mis.lis.prescription.PatientDTO;
import mis.lis.prescription.PrescriptionDTO;
import mis.lis.report.Report;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;
import java.util.Calendar;
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

  @Test
  public void testTransformation() throws ReportDataException, JAXBException {
    ReportTransformer transformer = new ReportTransformer();

    ReportRoot report = (ReportRoot) unmarshaller.unmarshal(getResourceAsStream("reports/15350001.xml"));
    final List<Observation> observations = report.getObservations();
    for (Observation observation : observations) {
      final List<Report> reports = transformer.transformToReport(observation);

      //Печать результата
      for (Report misReport : reports){
        final StringWriter writer= new StringWriter();
        reportMarshaller.marshal(misReport, writer);
        System.out.println(writer.toString());
      }
    }
  }
}
