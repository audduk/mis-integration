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
 * ДТО. Отчет о проведенных исследованиях
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportGroup {
  /** ResTableDescription	*	Наименование вида исследований	String(512) */
  @XmlElement(name = "ResTableDescription")
  private String resultDescription;
  /** ReportSeq		Порядок в отчете	SmallInt */
  @XmlElement(name = "ReportSeq")
  private Integer orderNumber;
  /** FinishDate	*	Дата завершения исследований	Date	ГОСТ ИСО 8601 */
  @XmlJavaTypeAdapter(DateAdapter.class)
  @XmlElement(name = "FinishDate")
  private Calendar finishDate;
  /** VerifierID		Ответственное лицо, ID	SmallInt */
  @XmlElement(name = "VerifierID")
  private Integer verifierID;
  /** VerifierName		Ответственное лицо (ФИО)	String(512) */
  @XmlElement(name = "VerifierName")
  private String verifierName;
  /** Results		Список результатов	Container	элементов ObservationResult */
  @XmlElementWrapper(name = "Results")
  @XmlElement(name = "ObservationResult")
  private List<ObservationResult> results;

  public String getResultDescription() {
    return resultDescription;
  }

  public void setResultDescription(String resultDescription) {
    this.resultDescription = resultDescription;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Calendar getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Calendar finishDate) {
    this.finishDate = finishDate;
  }

  public Integer getVerifierID() {
    return verifierID;
  }

  public void setVerifierID(Integer verifierID) {
    this.verifierID = verifierID;
  }

  public String getVerifierName() {
    return verifierName;
  }

  public void setVerifierName(String verifierName) {
    this.verifierName = verifierName;
  }

  public List<ObservationResult> getResults() {
    return results;
  }

  public void setResults(List<ObservationResult> results) {
    this.results = results;
  }
}
