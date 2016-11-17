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
 * Вид оплаты за деньги
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractDTO extends PaymentDTO implements Serializable {
  private String number;
  private Calendar beginDate;
  private Calendar endDate;

  public ContractDTO() {
  }

  public ContractDTO(Long id, String number, Calendar beginDate, Calendar endDate) {
    super(id);
    this.number = number;
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

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
}

