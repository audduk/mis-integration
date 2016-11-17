package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 16:15
 * Справочник цель исследования
 */
public class ResearchTargetDTO extends DirectoryItemDTO implements Serializable {
  public ResearchTargetDTO() {
  }

  public ResearchTargetDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

