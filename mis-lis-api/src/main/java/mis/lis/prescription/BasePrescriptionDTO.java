package mis.lis.prescription;

import mis.dto.common.AbstractEntityDto;
import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:30
 * Базовый класс для направлений
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({InstrumentalDTO.class, LabPrescriptionDTO.class, HistologyLabPrescriptionDTO.class})
public abstract class BasePrescriptionDTO extends AbstractEntityDto implements Serializable {
  /**
   * Ячейка в расписании лаборатории(кабинета инструментальных исследований)
   */
  private QueueItemDTO queueItem;

  /**
   * Срочность
   */
  private UrgencyDTO urgency;

  /**
   * Обоснование срочности
   */
  private String explanation;

  /**
   * Дата направления
   */
  private Calendar referralDate;

  /**
   * Дополнительно
   */
  private String extraInformation;

  /**
   * Дополнительная информация по пациенту (резюме)
   */
  private  PatientResumeDTO patientResume;

  private DirectoryItemDTO diagnosis;

  protected BasePrescriptionDTO() {
  }

  protected BasePrescriptionDTO(Long id, QueueItemDTO queueItem, UrgencyDTO urgency, String explanation, Calendar referralDate) {
    super(id);
    this.queueItem = queueItem;
    this.urgency = urgency;
    this.explanation = explanation;
    this.referralDate = referralDate;
  }

  public QueueItemDTO getQueueItem() {
    return queueItem;
  }

  public void setQueueItem(QueueItemDTO queueItem) {
    this.queueItem = queueItem;
  }

  public UrgencyDTO getUrgency() {
    return urgency;
  }

  public void setUrgency(UrgencyDTO urgency) {
    this.urgency = urgency;
  }

  public String getExplanation() {
    return explanation;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  public Calendar getReferralDate() {
    return referralDate;
  }

  public void setReferralDate(Calendar referralDate) {
    this.referralDate = referralDate;
  }

  public PatientResumeDTO getPatientResume() {
    return patientResume;
  }

  public void setPatientResume(PatientResumeDTO patientResume) {
    this.patientResume = patientResume;
  }

  public String getExtraInformation() {
    return extraInformation;
  }

  public void setExtraInformation(String extraInformation) {
    this.extraInformation = extraInformation;
  }

  public DirectoryItemDTO getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(DirectoryItemDTO diagnosis) {
    this.diagnosis = diagnosis;
  }
}

