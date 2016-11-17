package mis.lis.prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}

