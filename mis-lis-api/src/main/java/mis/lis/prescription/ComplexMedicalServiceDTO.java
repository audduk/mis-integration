package mis.lis.prescription;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 17:17
 */
public class ComplexMedicalServiceDTO extends ManipulationDTO implements Serializable {
  public ComplexMedicalServiceDTO() {
  }

  public ComplexMedicalServiceDTO(Long id, String code, String name, String shortName, String tfomsCode, Boolean notPayedByTfoms) {
    super(id, code, name, shortName, tfomsCode, notPayedByTfoms);
  }
}

