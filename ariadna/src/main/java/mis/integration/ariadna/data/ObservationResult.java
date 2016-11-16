package mis.integration.ariadna.data;

import mis.integration.ariadna.data.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

/**
 * ДТО. Результат конкретного ЛИ (теста)
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ObservationResult {
  /** SeqNo	*	Номер строки в отчете	SmallInt */
  @XmlElement(name = "SeqNo")
  private Integer reportOrder;
  /** RepLevel		Уровень вложенности в отчете	SmallInt */
  @XmlElement(name = "RepLevel")
  private Integer reportLevel;
  /** HeaderMark		Метка заголовка (H)	String(1) */
  @XmlElement(name = "HeaderMark")
  private String headerMark;
  /** ReportFormat		Имя формата отчета	String(512) */
  @XmlElement(name = "ReportFormat")
  private String reportFormat;

  /** OrderedServiceID		ID услуги, в рамках которой был получен результат	NUMBER(12) */
  @XmlElement(name = "OrderedServiceID")
  private Long orderedServiceID;
  /** OrderedWorkID		ID работы, при выполнении которой был получен результат	NUMBER(12) */
  @XmlElement(name = "OrderedWorkID")
  private Long orderedWorkID;

  /**
   * CodesetID		признак результата из кодового набора
   * В этом случае, значение результата (ResultValue ) нужно получить путем вычитания из значения тега ResultText
   * значения тегов Unit, NormText и всех пробельных символов
   */
  @XmlElement(name = "CodesetID")
  private String сodesetID;

  /** Pathology		Отметка патологии	String(3) */
  @XmlElement(name = "Pathology")
  private String pathology;
  /** MeasurementName	*	Наименование измерения	String(256) */
  @XmlElement(name = "MeasurementName")
  private String measurementName;
  /** MeasurementShortName		Наименование измерения краткое	String(256) */
  @XmlElement(name = "MeasurementShortName")
  private String measurementShortName;
  /** ResultText		Полный текст значения измерения	String(2048) */
  @XmlElement(name = "ResultText")
  private String resultText;
  /** ResultValue		Значение измерения	String(1024) */
  @XmlElement(name = "ResultValue")
  private String resultValue;
  /** NormMin		Минимальное значение референтного интервала	NUMBER(15) */
  @XmlElement(name = "NormMin")
  private String normMin;
  /** NormMax		Максимальное значение референтного интервала	NUMBER(15) */
  @XmlElement(name = "NormMax")
  private String normMax;
  /** NormText		Текстовая форма референтного интервала	String(100) */
  @XmlElement(name = "NormText")
  private String normText;
  /** FinishDate	*	Дата завершения измерения	Date	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "FinishDate")
  private Calendar finishDate;
  /** ResCount		Количество полученных результатов	SmallInt */
  @XmlElement(name = "ResCount")
  private Integer resCount;
  /** ResCode		Код, идентифицирующий измерение (элемент структуры результатов)	String(2048) */
  @XmlElement(name = "ResCode")
  private String resCode;
  /** DependOnResCode		Ссылка на родительский результат (ResCode) для иерархически связанных результатов	String(2048) */
  @XmlElement(name = "DependOnResCode")
  private String dependOnResCode;
  /** MeasurementID		идентификатор карточки результата (элемент структуры результатов). Может использоваться для группировки нескольких измерений в один результат.	String(2048) */
  @XmlElement(name = "MeasurementID")
  private String measurementID;
  /** Requested		Результат был заказан?	Boolean */
  @XmlElement(name = "Requested")
  private Boolean requested;

  public Integer getReportOrder() {
    return reportOrder;
  }

  public void setReportOrder(Integer reportOrder) {
    this.reportOrder = reportOrder;
  }

  public Integer getReportLevel() {
    return reportLevel;
  }

  public void setReportLevel(Integer reportLevel) {
    this.reportLevel = reportLevel;
  }

  public String getHeaderMark() {
    return headerMark;
  }

  public void setHeaderMark(String headerMark) {
    this.headerMark = headerMark;
  }

  public String getReportFormat() {
    return reportFormat;
  }

  public void setReportFormat(String reportFormat) {
    this.reportFormat = reportFormat;
  }

  public Long getOrderedServiceID() {
    return orderedServiceID;
  }

  public void setOrderedServiceID(Long orderedServiceID) {
    this.orderedServiceID = orderedServiceID;
  }

  public Long getOrderedWorkID() {
    return orderedWorkID;
  }

  public void setOrderedWorkID(Long orderedWorkID) {
    this.orderedWorkID = orderedWorkID;
  }

  public String getСodesetID() {
    return сodesetID;
  }

  public void setСodesetID(String сodesetID) {
    this.сodesetID = сodesetID;
  }

  public String getPathology() {
    return pathology;
  }

  public void setPathology(String pathology) {
    this.pathology = pathology;
  }

  public String getMeasurementName() {
    return measurementName;
  }

  public void setMeasurementName(String measurementName) {
    this.measurementName = measurementName;
  }

  public String getMeasurementShortName() {
    return measurementShortName;
  }

  public void setMeasurementShortName(String measurementShortName) {
    this.measurementShortName = measurementShortName;
  }

  public String getResultText() {
    return resultText;
  }

  public void setResultText(String resultText) {
    this.resultText = resultText;
  }

  public String getResultValue() {
    return resultValue;
  }

  public void setResultValue(String resultValue) {
    this.resultValue = resultValue;
  }

  public String getNormMin() {
    return normMin;
  }

  public void setNormMin(String normMin) {
    this.normMin = normMin;
  }

  public String getNormMax() {
    return normMax;
  }

  public void setNormMax(String normMax) {
    this.normMax = normMax;
  }

  public String getNormText() {
    return normText;
  }

  public void setNormText(String normText) {
    this.normText = normText;
  }

  public Calendar getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Calendar finishDate) {
    this.finishDate = finishDate;
  }

  public Integer getResCount() {
    return resCount;
  }

  public void setResCount(Integer resCount) {
    this.resCount = resCount;
  }

  public String getResCode() {
    return resCode;
  }

  public void setResCode(String resCode) {
    this.resCode = resCode;
  }

  public String getDependOnResCode() {
    return dependOnResCode;
  }

  public void setDependOnResCode(String dependOnResCode) {
    this.dependOnResCode = dependOnResCode;
  }

  public String getMeasurementID() {
    return measurementID;
  }

  public void setMeasurementID(String measurementID) {
    this.measurementID = measurementID;
  }

  public Boolean getRequested() {
    return requested;
  }

  public void setRequested(Boolean requested) {
    this.requested = requested;
  }
}
