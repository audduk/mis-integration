package mis.integration.ariadna.war;

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

import java.io.File;

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

  @Test
  public void testLisReportFileTransformationAlgo() {
    File file = getResourceFile("reports/15350001.xml");
    Message<File> message = MessageBuilder.withPayload(file).build();
    lisReportFileInputChannel.send(message);
  }
}
