package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 14:59
 * Справочник биоматериалов
 */
public class BiomaterialDTO extends DirectoryItemDTO implements Serializable {
  public BiomaterialDTO() {
  }

  public BiomaterialDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

