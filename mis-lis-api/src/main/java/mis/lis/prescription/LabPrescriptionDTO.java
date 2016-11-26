package mis.lis.prescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:44
 * Направление на лабораторное исследование
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LabPrescriptionDTO extends BasePrescriptionDTO implements Serializable {
  /**
   * Биоматериал
   */
  private Set<BiomaterialDTO> biomaterials;
  /**
   * Место забора биоматериала
   */
  private BiomaterialTakingPlaceDTO biomaterialTakingPlace;
  /**
   * Описание биоматериала
   */
  private String biomaterialDescription;
  /**
   * Единицы измерения биоматериала
   */
  private String biomaterialMarking;
  /**
   * Объем биоматериала
   */
  private String biomaterialCount;
  /**
   * Дополнительно
   */
  private String extraInformation;
  /**
   * Цель исследования
   */
  private ResearchTargetDTO researchTarget;

  /**
   * Услуга по забору биоматериала
   */
  private SimpleMedicalServiceDTO serviceTakingName;

  /**
   * Набор лабораторных услуг
   */
  private Set<ManipulationDTO> manipulations;

  /**
   * Доп.параметры назначения
   */
  private String additionalParameters;

  public Set<BiomaterialDTO> getBiomaterials() {
    return biomaterials;
  }

  public void setBiomaterials(Set<BiomaterialDTO> biomaterials) {
    this.biomaterials = biomaterials;
  }

  public BiomaterialTakingPlaceDTO getBiomaterialTakingPlace() {
    return biomaterialTakingPlace;
  }

  public void setBiomaterialTakingPlace(BiomaterialTakingPlaceDTO biomaterialTakingPlace) {
    this.biomaterialTakingPlace = biomaterialTakingPlace;
  }

  public String getBiomaterialDescription() {
    return biomaterialDescription;
  }

  public void setBiomaterialDescription(String biomaterialDescription) {
    this.biomaterialDescription = biomaterialDescription;
  }

  public String getBiomaterialMarking() {
    return biomaterialMarking;
  }

  public void setBiomaterialMarking(String biomaterialMarking) {
    this.biomaterialMarking = biomaterialMarking;
  }

  public String getBiomaterialCount() {
    return biomaterialCount;
  }

  public void setBiomaterialCount(String biomaterialCount) {
    this.biomaterialCount = biomaterialCount;
  }

  @Override
  public String getExtraInformation() {
    return extraInformation;
  }

  @Override
  public void setExtraInformation(String extraInformation) {
    this.extraInformation = extraInformation;
  }

  public ResearchTargetDTO getResearchTarget() {
    return researchTarget;
  }

  public void setResearchTarget(ResearchTargetDTO researchTarget) {
    this.researchTarget = researchTarget;
  }

  public SimpleMedicalServiceDTO getServiceTakingName() {
    return serviceTakingName;
  }

  public void setServiceTakingName(SimpleMedicalServiceDTO serviceTakingName) {
    this.serviceTakingName = serviceTakingName;
  }

  public Set<ManipulationDTO> getManipulations() {
    return manipulations;
  }

  public void setManipulations(Set<ManipulationDTO> manipulations) {
    this.manipulations = manipulations;
  }

  public String getAdditionalParameters() {
    return additionalParameters;
  }

  public void setAdditionalParameters(String additionalParameters) {
    this.additionalParameters = additionalParameters;
  }
}

