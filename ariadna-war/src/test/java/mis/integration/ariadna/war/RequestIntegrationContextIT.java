package mis.integration.ariadna.war;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Тестируем настройку схемы обработки файла с протоколом ЛИ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RequestIntegrationContextIT.Config.class)
public class RequestIntegrationContextIT extends AbstractAriadnaTest {

  @Configuration
  @PropertySource("classpath:application.properties")
  @ImportResource(locations = {"classpath:request-integration.xml"})
  public static class Config {
  }

  @Autowired
  @Qualifier("prescriptionFileInputChannel")
  private MessageChannel prescriptionFileInputChannel;

  @Test
  public void testMisPrescriptionTransformationAlgo() throws InterruptedException {
    File file = getResourceFile("requests/request.xml");
    Message<File> message = MessageBuilder.withPayload(file).build();
    prescriptionFileInputChannel.send(message);
    Thread.sleep(300); //требуется после добавления poller-а по умолчанию
  }
}
