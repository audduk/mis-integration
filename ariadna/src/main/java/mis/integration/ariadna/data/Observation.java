package mis.integration.ariadna.data;

import mis.integration.ariadna.data.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.List;

/**
 * ДТО. Заказ на проведение ЛИ
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Observation {
  /** ID	* Идентификатор документа	NUMBER(12)	12 знаков */
  @XmlElement(name = "ID")
  private Long id;
  /** IDs		Идентификатор материала	String(16)	Возможно 6,8,10 знаков (конфигурация ЛИС) */
  @XmlElement(name = "IDs")
  private String materialId;
  /** RegDate	*	Дата регистрации	DATE	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "RegDate")
  private Calendar regDate;
  /** Status		Статус материала	String(1)	I, S, A, R, X, F */
  @XmlElement(name = "Status")
  private String materialStatus;
  /** ReportDate		Дата выдачи отчета	DATE	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "ReportDate")
  private Calendar reportDate;
  /** FinishDate		Дата завершения исследований	DATE	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "FinishDate")
  private Calendar finishDate;
  /** HisOrderID		Внутренний идентификатор заказа в МИС	String(40) */
  @XmlElement(name = "HisOrderID")
  private String misOrderID;
  /** OrderID		Номер направления	String(20) */
  @XmlElement(name = "OrderID")
  private String orderID;
  /** OrderDate		Дата заказа	DATE	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "OrderDate")
  private Calendar orderDate;
  /** SpecimenTypeID	*	Типа материала, ID по справочнику	NUMBER(12) */
  @XmlElement(name = "SpecimenTypeID")
  private Long specimenTypeID;
  /** SpecimenType	*	Тип материала, наименование	String(512) */
  @XmlElement(name = "SpecimenType")
  private String specimenType;
  /** SpecimenSiteID		Место взятия, ID по справочнику	NUMBER(12) */
  @XmlElement(name = "SpecimenSiteID")
  private Long specimenSiteID;
  /** SpecimenSite		Место взятия, наименование	String(512) */
  @XmlElement(name = "SpecimenSite")
  private String specimenSite;
  /** Cito		Срочность заказа	Boolean	true/false */
  @XmlElement(name = "Cito")
  private Boolean cito;
  /** PurposeID		Цель исследования, ID по справочнику	NUMBER(12) */
  @XmlElement(name = "PurposeID")
  private Long purposeID;
  /** Purpose		Цель исследования	String(512) */
  @XmlElement(name = "Purpose")
  private String purpose;
  /** CollectDate		Дата взятия материала	DateTime	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "CollectDate")
  private Calendar collectDate;
  /** InfoMessage		Информационное сообщение для персонала лаборатории или заказчика	String(1024) */
  @XmlElement(name = "InfoMessage")
  private String message;
  /** Patient		Информация о пациенте */
  @XmlElement(name = "Patient")
  private Patient patient;
  /** OrderingInstitution		Информация о заказчике */
  @XmlElement(name = "OrderingInstitution")
  private OrderingInstitution institution;
  /** OrderInfo		Информация о заказе, контейнер для элементов "item" */
  @XmlElementWrapper(name = "OrderInfo")
  @XmlElement(name = "item") //TODO Подтвердить, что "item" пишется с маленькой буквы (в описании с большой)
  private List<OrderItem> orderItems;
  /** ObservationReport		Результаы исследований, контейнер для элементов ReportGroup */
  @XmlElementWrapper(name = "ObservationReport")
  @XmlElement(name = "ReportGroup")
  private List<ReportGroup> reportGroups;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  public Calendar getRegDate() {
    return regDate;
  }

  public void setRegDate(Calendar regDate) {
    this.regDate = regDate;
  }

  public String getMaterialStatus() {
    return materialStatus;
  }

  public void setMaterialStatus(String materialStatus) {
    this.materialStatus = materialStatus;
  }

  public Calendar getReportDate() {
    return reportDate;
  }

  public void setReportDate(Calendar reportDate) {
    this.reportDate = reportDate;
  }

  public Calendar getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Calendar finishDate) {
    this.finishDate = finishDate;
  }

  public String getMisOrderID() {
    return misOrderID;
  }

  public void setMisOrderID(String misOrderID) {
    this.misOrderID = misOrderID;
  }

  public String getOrderID() {
    return orderID;
  }

  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }

  public Calendar getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Calendar orderDate) {
    this.orderDate = orderDate;
  }

  public Long getSpecimenTypeID() {
    return specimenTypeID;
  }

  public void setSpecimenTypeID(Long specimenTypeID) {
    this.specimenTypeID = specimenTypeID;
  }

  public String getSpecimenType() {
    return specimenType;
  }

  public void setSpecimenType(String specimenType) {
    this.specimenType = specimenType;
  }

  public Long getSpecimenSiteID() {
    return specimenSiteID;
  }

  public void setSpecimenSiteID(Long specimenSiteID) {
    this.specimenSiteID = specimenSiteID;
  }

  public String getSpecimenSite() {
    return specimenSite;
  }

  public void setSpecimenSite(String specimenSite) {
    this.specimenSite = specimenSite;
  }

  public Boolean getCito() {
    return cito;
  }

  public void setCito(Boolean cito) {
    this.cito = cito;
  }

  public Long getPurposeID() {
    return purposeID;
  }

  public void setPurposeID(Long purposeID) {
    this.purposeID = purposeID;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public Calendar getCollectDate() {
    return collectDate;
  }

  public void setCollectDate(Calendar collectDate) {
    this.collectDate = collectDate;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public OrderingInstitution getInstitution() {
    return institution;
  }

  public void setInstitution(OrderingInstitution institution) {
    this.institution = institution;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public List<ReportGroup> getReportGroups() {
    return reportGroups;
  }

  public void setReportGroups(List<ReportGroup> reportGroups) {
    this.reportGroups = reportGroups;
  }
}
