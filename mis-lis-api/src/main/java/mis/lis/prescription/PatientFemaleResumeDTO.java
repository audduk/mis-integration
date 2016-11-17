package mis.lis.prescription;


import mis.dto.common.DirectoryItemDTO;

/**
 * @author: petrov
 * Date: 30.10.13
 * Time: 9:38
 * Краткая информация по пациенту-женщине
 */
public class PatientFemaleResumeDTO extends  PatientResumeDTO{
  /**
   * Менопуза (возраст наступление менопаузы, лет)
   */
  private Integer menopause;

  /**
   * Срок беременности (минимум, дней)
   */
  private Integer pregnancyMin;

  /**
   * Срок беременности (максимум, дней)
   */
  private Integer pregnancyMax;

  /**
   * Фаза цикла
   */
  private DirectoryItemDTO cyclePhase;

  /**
   * Больные дети, описание
   */
  private String childrenIllness;

  /**
   * Мертворожденные, количество
   */
  private Integer stillbornQuantity;

  /**
   * Количество абортов
   */
  private Integer abortionsQuantity;


  public Integer getMenopause() {
    return menopause;
  }

  public void setMenopause(Integer menopause) {
    this.menopause = menopause;
  }

  public Integer getPregnancyMin() {
    return pregnancyMin;
  }

  public void setPregnancyMin(Integer pregnancyMin) {
    this.pregnancyMin = pregnancyMin;
  }

  public Integer getPregnancyMax() {
    return pregnancyMax;
  }

  public void setPregnancyMax(Integer pregnancyMax) {
    this.pregnancyMax = pregnancyMax;
  }

  public DirectoryItemDTO getCyclePhase() {
    return cyclePhase;
  }

  public void setCyclePhase(DirectoryItemDTO cyclePhase) {
    this.cyclePhase = cyclePhase;
  }

  public String getChildrenIllness() {
    return childrenIllness;
  }

  public void setChildrenIllness(String childrenIllness) {
    this.childrenIllness = childrenIllness;
  }

  public Integer getStillbornQuantity() {
    return stillbornQuantity;
  }

  public void setStillbornQuantity(Integer stillbornQuantity) {
    this.stillbornQuantity = stillbornQuantity;
  }

  public Integer getAbortionsQuantity() {
    return abortionsQuantity;
  }

  public void setAbortionsQuantity(Integer abortionsQuantity) {
    this.abortionsQuantity = abortionsQuantity;
  }
}
