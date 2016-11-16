package mis.integration.ariadna;

import mis.integration.ariadna.data.adapters.DateAdapter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Тест адаптера типа Date для формата обмена ЛИС Ариадна
 * @see mis.integration.ariadna.data.adapters.DateAdapter
 */
public class DateAdapterTest {
  private final static String DATE_VALUE = "1978-01-04";
  private final static String DATETIME_VALUE = "2015-12-15T10:18:29";

  @Test
  public void testMarshalDate() throws Exception {
    DateAdapter adapter = new DateAdapter();
    Calendar date = adapter.unmarshal(DATE_VALUE);
    String result = adapter.marshal(date);
    assertEquals("Неправильное преобразование даты", DATE_VALUE, result); //check "unmarshal" method before
  }

  @Test
  public void testUnmarshalDate() throws Exception {
    DateAdapter adapter = new DateAdapter();
    Calendar result = adapter.unmarshal(DATE_VALUE);
    assertEquals("Неправильный формат даты. Год", 1978, result.get(Calendar.YEAR));
    assertEquals("Неправильный формат даты. Месяц", 1, result.get(Calendar.MONTH)+1);
    assertEquals("Неправильный формат даты. День", 4, result.get(Calendar.DAY_OF_MONTH));
  }

  @Test
  public void testUnmarshalDateTime() throws Exception {
    DateAdapter adapter = new DateAdapter();
    Calendar result = adapter.unmarshal(DATETIME_VALUE);
    assertEquals("Неправильный формат даты. Год", 2015, result.get(Calendar.YEAR));
    assertEquals("Неправильный формат даты. Месяц", 12, result.get(Calendar.MONTH)+1);
    assertEquals("Неправильный формат даты. День", 15, result.get(Calendar.DAY_OF_MONTH));
  }
}
