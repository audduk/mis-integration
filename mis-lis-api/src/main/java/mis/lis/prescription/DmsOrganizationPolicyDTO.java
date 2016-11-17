package mis.lis.prescription;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Date: 04.02.13
 * Полис ДМС через организацию.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DmsOrganizationPolicyDTO extends PaymentDTO implements Serializable {

  /**
   * Номер
   */
  private String number;

  /**
   * Организация
   */
  private String organization;

  /**
   * Дата начала действия
   */
  private Calendar beginDate;

  /**
   * Дата окончания действия
   */
  private Calendar endDate;

  public DmsOrganizationPolicyDTO(){
    super();
  }

  public DmsOrganizationPolicyDTO(Long id, String organization, String number, Calendar beginDate, Calendar endDate) {
    super(id);
    this.number = number;
    this.organization = organization;
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  // *** Методы доступа


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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }
}
