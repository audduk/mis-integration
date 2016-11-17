package mis.lis.prescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 9:48
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VmpCouponDTO extends PaymentDTO implements Serializable {
  private String number;
  private Calendar date;

  public VmpCouponDTO() {
  }

  public VmpCouponDTO(Long id, String number, Calendar date) {
    super(id);
    this.number = number;
    this.date = date;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }
}

