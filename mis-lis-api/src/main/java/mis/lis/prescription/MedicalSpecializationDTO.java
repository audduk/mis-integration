package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 17:38
 * Медицинская специализация
 */
public class  MedicalSpecializationDTO extends DirectoryItemDTO implements Serializable {
  public MedicalSpecializationDTO() {
  }

  public MedicalSpecializationDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

