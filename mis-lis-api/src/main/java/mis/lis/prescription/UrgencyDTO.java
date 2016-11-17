package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 14:53
 * Справочник срочность
 */
public class UrgencyDTO extends DirectoryItemDTO implements Serializable {
  public UrgencyDTO() {
  }

  public UrgencyDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

