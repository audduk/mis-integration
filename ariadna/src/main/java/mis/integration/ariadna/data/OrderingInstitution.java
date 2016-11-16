package mis.integration.ariadna.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * ДТО. Информация о заказчике (подразделение)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderingInstitution {
  /** ID	*	Организация, ID в ЛИС	NUMBER(12) */
  @XmlElement(name = "ID")
  private Long id;
  /** LocalName		Наименование краткое	String(30) */
  @XmlElement(name = "LocalName")
  private String name;
  /** FullName		Наименование полное	String(512) */
  @XmlElement(name = "FullName")
  private String fullName;
  /** Code		Регистрационный код	String(32) */
  @XmlElement(name = "Code")
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
