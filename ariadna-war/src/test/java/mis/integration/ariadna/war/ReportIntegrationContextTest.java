package mis.integration.ariadna.war;

import mis.lis.prescription.LabPrescriptionDTO;
import mis.lis.prescription.PatientDTO;
import mis.lis.prescription.PrescriptionDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.Calendar;

/**
 * Тестируем настройку схемы обработки файла с протоколом ЛИ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration("classpath:report-integration.xml")
public class ReportIntegrationContextTest extends AbstractAriadnaTest {
  @Autowired
  @Qualifier("lisReportFileInputChannel")
  private DirectChannel lisReportFileInputChannel;

  @Autowired
  @Qualifier("prescriptionFileInputChannel")
  private DirectChannel prescriptionFileInputChannel;

  private Marshaller marshaller;

  @Before
  public void initMarshaller() throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(PrescriptionDTO.class);
    marshaller = jc.createMarshaller();
  }

  @Test
  public void testLisReportFileTransformationAlgo() {
    File file = getResourceFile("reports/15350001.xml");
    Message<File> message = MessageBuilder.withPayload(file).build();
    lisReportFileInputChannel.send(message);
  }

  @Test
  public void testMisPrescriptionTransformationAlgo() throws JAXBException {
    File file = getResourceFile("requests/request.xml");
    Message<File> message = MessageBuilder.withPayload(file).build();
    prescriptionFileInputChannel.send(message);
  }
}
