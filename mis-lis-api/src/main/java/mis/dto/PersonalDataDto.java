package mis.dto;

import lombok.Getter;
import lombok.Setter;
import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Personal Data Transfer Object
 */
@XmlRootElement
@Getter
@Setter
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
}
