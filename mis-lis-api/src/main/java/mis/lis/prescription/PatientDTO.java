package mis.lis.prescription;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getInPatientCode() {
    return inPatientCode;
  }

  public void setInPatientCode(String inPatientCode) {
    this.inPatientCode = inPatientCode;
  }

  public Calendar getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Calendar birthDate) {
    this.birthDate = birthDate;
  }

  public DirectoryItemDTO getSex() {
    return sex;
  }

  public void setSex(DirectoryItemDTO sex) {
    this.sex = sex;
  }

  public DirectoryItemDTO getSocialStatus() {
    return socialStatus;
  }

  public void setSocialStatus(DirectoryItemDTO socialStatus) {
    this.socialStatus = socialStatus;
  }

  public WorkInfoDTO getWorkInfo() {
    return workInfo;
  }

  public void setWorkInfo(WorkInfoDTO workInfo) {
    this.workInfo = workInfo;
  }

  public DirectoryItemDTO getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(DirectoryItemDTO bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public IdentityCardDTO getIdentityCard() {
    return identityCard;
  }

  public void setIdentityCard(IdentityCardDTO identityCard) {
    this.identityCard = identityCard;
  }

  public String getResidenceAddress() {
    return residenceAddress;
  }

  public void setResidenceAddress(String residenceAddress) {
    this.residenceAddress = residenceAddress;
  }
}

