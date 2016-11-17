package mis.lis.prescription;

import lombok.Getter;
import lombok.Setter;
import mis.dto.IdentityCardDTO;
import mis.dto.PersonalDataDto;
import mis.dto.WorkInfoDTO;
import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:26
 * Пациент
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class PatientDTO extends PersonalDataDto implements Serializable {
  /**
   * Номер АКБ (Амбулаторной карты)
   */
  private String code;

  /**
  * Номер ИБ (Истории болезни)
  */
  private String inPatientCode;

  /**
   * Дата рождения
   */
  private Calendar birthDate;

  /**
   * Пол пациента
   */
  private DirectoryItemDTO sex;

  /**
   * Информация о социальном статусе пациента
   */
  private DirectoryItemDTO socialStatus;

  /**
   * Информация о месте работы пациента
   */
  private WorkInfoDTO workInfo;

  /**
   * Группа крови
   */
  private DirectoryItemDTO bloodGroup;

  /**
   * Документ удостоверяющий личность
   */
  private IdentityCardDTO identityCard;

  /**
   * Адрес местожительства
   */
  private String residenceAddress;

}

