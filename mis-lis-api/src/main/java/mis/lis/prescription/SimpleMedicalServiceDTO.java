package mis.lis.prescription;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 17:11
 */
public class SimpleMedicalServiceDTO extends ManipulationDTO implements Serializable {
  private String codeBase;
  /**
   * Требует дополнительного оборудования
   */
  private Boolean equipmentRequired;

  public SimpleMedicalServiceDTO() {
  }

  public SimpleMedicalServiceDTO(Long id, String code, String name, String shortName, String tfomsCode,
                                 Boolean notPayedByTfoms, String codeBase, Boolean equipmentRequired) {
    super(id, code, name, shortName, tfomsCode, notPayedByTfoms);
    this.codeBase = codeBase;
    this.equipmentRequired = equipmentRequired;
  }

  public String getCodeBase() {
    return codeBase;
  }

  public void setCodeBase(String codeBase) {
    this.codeBase = codeBase;
  }

  public Boolean getEquipmentRequired() {
    return equipmentRequired;
  }

  public void setEquipmentRequired(Boolean equipmentRequired) {
    this.equipmentRequired = equipmentRequired;
  }
}

