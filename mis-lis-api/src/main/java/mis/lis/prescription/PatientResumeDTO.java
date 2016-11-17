package mis.lis.prescription;



/**
 * @author: petrov
 * Date: 30.10.13
 * Time: 9:35
 * Краткая информация по пациенту
 */
public class PatientResumeDTO {
  /**
   * Контингент
   */
  private String contingent;

  /**
   * Сведения об отягощающих хронических заболеваниях
   */
  private String complicatingIllness;

  /**
   * Данные по предшевствующему лечению
   */
  private String previousTreatment;

  /**
   * Сведения об аллергии на применяемые препараты
   */
  private String allergy;

  /**
   * Вес пациента (кг)
   */
  private Integer weight;

  /**
   * Рост пациента (см)
   */
  private Integer growth;

  public String getContingent() {
    return contingent;
  }

  public void setContingent(String contingent) {
    this.contingent = contingent;
  }

  public String getComplicatingIllness() {
    return complicatingIllness;
  }

  public void setComplicatingIllness(String complicatingIllness) {
    this.complicatingIllness = complicatingIllness;
  }

  public String getPreviousTreatment() {
    return previousTreatment;
  }

  public void setPreviousTreatment(String previousTreatment) {
    this.previousTreatment = previousTreatment;
  }

  public String getAllergy() {
    return allergy;
  }

  public void setAllergy(String allergy) {
    this.allergy = allergy;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getGrowth() {
    return growth;
  }

  public void setGrowth(Integer growth) {
    this.growth = growth;
  }
}
