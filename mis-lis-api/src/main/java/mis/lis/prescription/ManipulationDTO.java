package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 17:13
 * Манипуляция
 */
public class ManipulationDTO extends DirectoryItemDTO implements Serializable {
  /**
   * Сокращенное наименование
   */
  private String shortName;
  /**
   * Код ТФОМС
   */
  private String tfomsCode;
  /**
   * Признак что фомс не оплачивает
   */
  private Boolean isNotPayedByTfoms;

  public ManipulationDTO() {
  }

  public ManipulationDTO(Long id, String code, String name, String shortName, String tfomsCode, Boolean notPayedByTfoms) {
    super(id, code, name);
    this.shortName = shortName;
    this.tfomsCode = tfomsCode;
    isNotPayedByTfoms = notPayedByTfoms;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getTfomsCode() {
    return tfomsCode;
  }

  public void setTfomsCode(String tfomsCode) {
    this.tfomsCode = tfomsCode;
  }

  public Boolean getNotPayedByTfoms() {
    return isNotPayedByTfoms;
  }

  public void setNotPayedByTfoms(Boolean notPayedByTfoms) {
    isNotPayedByTfoms = notPayedByTfoms;
  }
}

