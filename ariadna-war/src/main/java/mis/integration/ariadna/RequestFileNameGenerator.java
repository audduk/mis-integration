package mis.integration.ariadna;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

import java.util.Calendar;

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
    final Calendar date = Calendar.getInstance();
    int year = date.get(Calendar.YEAR);                //порядковый номер года
    year -= (year > 2000) ? 2000 : 0;
    final int days = date.get(Calendar.DAY_OF_YEAR);   //порядковый номер дня в году
    final int number = getMessageNumber(message);      //порядковый номер сообщения в течение дня (в 36-чной системе)
    final String name = String.format("%02d%03d%03d", year, days, number);

    return name + "." + extension;
  }

  private int getMessageNumber(Message<?> message) {
    return 0;
  }
}
