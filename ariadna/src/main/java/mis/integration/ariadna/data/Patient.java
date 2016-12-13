package mis.integration.ariadna.data;

import mis.integration.ariadna.data.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

/**
 * ДТО. Информация о пациента
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
  /** ID		Уникальный ID в ЛИС	NUMBER(12) */
  @XmlElement(name = "ID")
  private Long id;
  /** RegCode	*	ID пациента в МИС	String(20) */
  @XmlElement(name = "RegCode")
  private String misId;
  /** GivenName		Имя	String(100) */
  @XmlElement(name = "GivenName")
  private String givenName;
  /** FamilyName	*	Фамилия	String(100) */
  @XmlElement(name = "FamilyName")
  private String familyName;
  /** MiddleName		Отчество	String(100) */
  @XmlElement(name = "MiddleName")
  private String middleName;
  /** Address		Адрес	String(500) */
  @XmlElement(name = "Address")
  private String address;
  /** Phone		Телефон домашний	String(64) */
  @XmlElement(name = "Phone")
  private String phone;
  /** CellularPhone		Телефон сотовый	String(64) */
  @XmlElement(name = "CellularPhone")
  private String cellularPhone;
  /** RelativePhone		Телефон родственников	String(128) */
  @XmlElement(name = "RelativePhone")
  private String relativePhone;
  /** Gender		Пол	String(1)	M, F, пробел */
  @XmlElement(name = "Gender")
  private String gender;
  /** BirthDate		Дата рождения	DATE	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "BirthDate")
  private Calendar birthDate;
  /** RegDate		Дата регистрации	DATE */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "RegDate")
  private Calendar regDate;
  /** ConditionID		Состояние пациента, ID по справочнику	NUMBER(12) */
  @XmlElement(name = "ConditionID")
  private String conditionID;
  /** Condition		Состояние пациента, наименование  	String(512)*/
  @XmlElement(name = "Condition")
  private String condition;
  /** Notes		Комментарий	String(128) */
  @XmlElement(name = "Notes")
  private String notes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMisId() {
    return misId;
  }

  public void setMisId(String misId) {
    this.misId = misId;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCellularPhone() {
    return cellularPhone;
  }

  public void setCellularPhone(String cellularPhone) {
    this.cellularPhone = cellularPhone;
  }

  public String getRelativePhone() {
    return relativePhone;
  }

  public void setRelativePhone(String relativePhone) {
    this.relativePhone = relativePhone;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Calendar getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Calendar birthDate) {
    this.birthDate = birthDate;
  }

  public Calendar getRegDate() {
    return regDate;
  }

  public void setRegDate(Calendar regDate) {
    this.regDate = regDate;
  }

  public String getConditionID() {
    return conditionID;
  }

  public void setConditionID(String conditionID) {
    this.conditionID = conditionID;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
