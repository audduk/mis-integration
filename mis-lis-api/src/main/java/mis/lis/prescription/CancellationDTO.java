package mis.lis.prescription;

import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * @author: petrov
 * Date: 27.12.13
 * Time: 11:15
 * Отмена направления
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CancellationDTO extends AbstractEntityDto {

  /**
   * Идентификатор направления
   */
  @XmlElement
  Long requestID;
  /**
   * Информация о сотруднике
   */
  @XmlElement
  EmployeeDTO employee;

  /**
   * Основание для отмены направления
   */
  @XmlElement
  String basis;

  /**
   * Дата отмены направления
   */
  @XmlElement
  Calendar date;

  public Long getRequestID() {
    return requestID;
  }

  public void setRequestID(Long requestID) {
    this.requestID = requestID;
  }

  public EmployeeDTO getEmployee() {
    return employee;
  }

  public void setEmployee(EmployeeDTO employee) {
    this.employee = employee;
  }

  public String getBasis() {
    return basis;
  }

  public void setBasis(String basis) {
    this.basis = basis;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }
}
