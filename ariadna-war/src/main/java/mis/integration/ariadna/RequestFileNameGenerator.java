package mis.integration.ariadna;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * Алгоритм генерации имени файла
 */
public class RequestFileNameGenerator implements FileNameGenerator {
  private String extension;

  public RequestFileNameGenerator(String extension) {
    this.extension = extension;
  }

  @Override
  public String generateFileName(Message<?> message) {
    final String name = (String) message.getHeaders().get("output-file-code");
    return name + "." + extension;
  }
}
