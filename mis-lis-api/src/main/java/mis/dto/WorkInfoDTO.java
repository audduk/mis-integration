package mis.dto;

import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Получение данных о родственниках/законных представителях
 * @author : Миловидов Андрей
 *         Date: 26.03.13
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class WorkInfoDTO {

  @XmlElement
  private String workPlace;

  @XmlElement
  private DirectoryItemDTO profession;

  @XmlElement
  private DirectoryItemDTO militaryRank;

  @XmlElement
  private DirectoryItemDTO forcesStructure;

  @XmlElement
  private String position;

  @XmlElement
  private DirectoryItemDTO dirWorkPlace;

  /**
   * Табельный №
   */
  @XmlElement
  private String personnelNumber;

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
  }

  /**
   * Получение профессии
   * @return profession - Профессия
   */
  public DirectoryItemDTO getProfession() {
    return profession;
  }

  /**
   * Установка профессии
   * @param profession Профессия
   */
  public void setProfession(DirectoryItemDTO profession) {
    this.profession = profession;
  }

  /**
   * Получение звания военнослужащего
   * @return militaryRank - Звание военнослужащего
   */
  public DirectoryItemDTO getMilitaryRank() {
    return militaryRank;
  }

  /**
   * Установка звания военнослужащего
   * @param militaryRank Звание военнослужащего
   */
  public void setMilitaryRank(DirectoryItemDTO militaryRank) {
    this.militaryRank = militaryRank;
  }

  /**
   * Получение принадлежности к силовым структурам
   * @return forcesStructure - Принадлежность к силовым структурам
   */
  public DirectoryItemDTO getForcesStructure() {
    return forcesStructure;
  }

  /**
   * Установка принадлежности к силовым структурам
   * @param forcesStructure Принадлежность к силовым структурам
   */
  public void setForcesStructure(DirectoryItemDTO forcesStructure) {
    this.forcesStructure = forcesStructure;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public DirectoryItemDTO getDirWorkPlace() {
    return dirWorkPlace;
  }

  public void setDirWorkPlace(DirectoryItemDTO dirWorkPlace) {
    this.dirWorkPlace = dirWorkPlace;
  }

  public String getPersonnelNumber() {
    return personnelNumber;
  }

  public void setPersonnelNumber(String personnelNumber) {
    this.personnelNumber = personnelNumber;
  }
}
