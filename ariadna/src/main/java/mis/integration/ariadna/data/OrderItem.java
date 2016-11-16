package mis.integration.ariadna.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * ДТО. Заказанная услуга
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {
  /** ServiceID	*	Услуга, ID по справочнику ЛИС	NUMBER(12) */
  @XmlElement(name = "ServiceID")
  private Long serviceID;
  /** Service	*	Наименование услуги	String(512) */
  @XmlElement(name = "Service")
  private String service;
  /** ServiceCode		Наименование услуги, кратко	String(24) */
  @XmlElement(name = "ServiceCode")
  private String serviceCode;
  /** Completed		1 - Услуга выполнена	NUMBER(2)	 */
  @XmlElement(name = "Completed")
  private Integer completed;

  public Long getServiceID() {
    return serviceID;
  }

  public void setServiceID(Long serviceID) {
    this.serviceID = serviceID;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getServiceCode() {
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }

  public Integer getCompleted() {
    return completed;
  }

  public void setCompleted(Integer completed) {
    this.completed = completed;
  }
}
