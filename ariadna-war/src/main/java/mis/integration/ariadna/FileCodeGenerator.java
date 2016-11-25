package mis.integration.ariadna;

import org.springframework.messaging.Message;

import java.util.Calendar;

/**
 * Расчет (бронирование) наименования генерируемого файла
 */
public class FileCodeGenerator {

  /** Порядковый номер запроса в течение дня */
  private int num = 0;
  /** Время последнего запроса */
  private int lastAccessDay = 0;

  public String computeValue(Message<?> message) {
    final Calendar date = Calendar.getInstance();
    int year = date.get(Calendar.YEAR);                //порядковый номер года
    year -= (year > 2000) ? 2000 : 0;
    final int days = date.get(Calendar.DAY_OF_YEAR);   //порядковый номер дня в году
    final int number = getMessageNumber(days);         //порядковый номер сообщения в течение дня (в 36-чной системе)
    return String.format("%02d%03d%03d", year, days, number);
  }

  private int getMessageNumber(int accessDay) {
    if (accessDay != lastAccessDay) {
      lastAccessDay = accessDay;
      num = 0;
    }
    ++num;
    return num;
  }
}
