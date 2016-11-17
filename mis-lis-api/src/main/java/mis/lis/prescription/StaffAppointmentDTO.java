package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 15:04
 * Справочник Должность
 */
public class StaffAppointmentDTO extends DirectoryItemDTO implements Serializable {
  public StaffAppointmentDTO() {
  }

  public StaffAppointmentDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

