package mis.lis.prescription;

import mis.dto.PersonalDataDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:25
 * Работник
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDTO extends PersonalDataDto implements Serializable {
  /**
   * должность
   */
  private StaffAppointmentDTO appointment;

  public EmployeeDTO() {
  }

  public EmployeeDTO(Long id, String firstName, String lastName, String middleName, StaffAppointmentDTO appointment) {
    super(id, firstName, lastName, middleName);
    this.appointment = appointment;
  }

  public StaffAppointmentDTO getAppointment() {
    return appointment;
  }

  public void setAppointment(StaffAppointmentDTO appointment) {
    this.appointment = appointment;
  }
}

