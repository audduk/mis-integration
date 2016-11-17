package mis.dto.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * Created by bayurov on 19.11.2014.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalSpecialityDTO extends DirectoryItemDTO {
  //Дата начала действия записи
  private Calendar beginDate;

  //Дата окончания действия записи
  private Calendar endDate;

  // код специальности в кодировке ТФОМС
  private String tfomsCode;

  public Calendar getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Calendar beginDate) {
    this.beginDate = beginDate;
  }

  public Calendar getEndDate() {
    return endDate;
  }

  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  public String getTfomsCode() {
    return tfomsCode;
  }

  public void setTfomsCode(String tfomsCode) {
    this.tfomsCode = tfomsCode;
  }
}
