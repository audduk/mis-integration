package mis.dto;

import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Personal Data Transfer Object
 */
@XmlRootElement
public class PersonalDataDto extends AbstractEntityDto implements Serializable {
  /**
   * Last Name
   */
  private String lastName;
  /**
   * First Name
   */
  private String firstName;
  /**
   * Middle Name
   */
  private String middleName;

  /**
   * Информация о поле пациента
   */
  private Boolean sexInfo;

  public PersonalDataDto() {
  }

  public PersonalDataDto(Long id, String firstName, String lastName, String middleName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Boolean getSexInfo() {
    return sexInfo;
  }

  public void setSexInfo(Boolean sexInfo) {
    this.sexInfo = sexInfo;
  }
}
