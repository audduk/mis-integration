package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 15:30
 * Место забора биоматериала
 */
public class BiomaterialTakingPlaceDTO extends DirectoryItemDTO implements Serializable {
  public BiomaterialTakingPlaceDTO() {
  }

  public BiomaterialTakingPlaceDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

