package mis.integration.ariadna;

import org.springframework.messaging.Message;

import java.util.Calendar;

/**
 * Расчет (бронирование) наименования генерируемого файла
 */
public class FileCodeGenerator {
  public String computeValue(Message<?> message) {
    final Calendar date = Calendar.getInstance();
    int year = date.get(Calendar.YEAR);                //порядковый номер года
    year -= (year > 2000) ? 2000 : 0;
    final int days = date.get(Calendar.DAY_OF_YEAR);   //порядковый номер дня в году
    final int number = getMessageNumber(message);      //порядковый номер сообщения в течение дня (в 36-чной системе)
    return String.format("%02d%03d%03d", year, days, number);
  }

  private int getMessageNumber(Message<?> message) {
    return 0;
  }
}
