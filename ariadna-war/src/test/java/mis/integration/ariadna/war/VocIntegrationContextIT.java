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
@ContextConfiguration(classes = VocIntegrationContextIT.Config.class)
public class VocIntegrationContextIT extends AbstractAriadnaTest {

  @Configuration
  @PropertySource("classpath:application.properties")
  @ImportResource(locations = {"classpath:voc-integration.xml"})
  public static class Config {
  }

  @Autowired
  @Qualifier("lisVocInput")
  private MessageChannel lisVocInput;

  @Test
  public void testUnknownVocProcessing() throws InterruptedException {
    File file = getResourceFile("voc/16357001.xml");
    Message<File> message = MessageBuilder.withPayload(file).build();
    lisVocInput.send(message);
    Thread.sleep(300); //требуется после добавления poller-а по умолчанию
  }
}
