package mis.integration.ariadna.data.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Преобразование даты в формате ЛИС Ариадна
 */
public final class DateAdapter extends XmlAdapter<String, Calendar> {
  private final static String ARIADNA_FORMAT = "yyyy-MM-dd";

  @Override
  public Calendar unmarshal(String v) throws Exception {
    // компонент времени для полного формата дата/время будет игнорироваться
    if (v == null)
      return null;
    SimpleDateFormat format = new SimpleDateFormat(ARIADNA_FORMAT);
    Calendar result = Calendar.getInstance();
    result.setTime(format.parse(v));
    return result;
  }

  @Override
  public String marshal(Calendar v) throws Exception {
    if (v == null)
      return null;
    SimpleDateFormat format = new SimpleDateFormat(ARIADNA_FORMAT);
    return format.format(v.getTime());
  }
}
