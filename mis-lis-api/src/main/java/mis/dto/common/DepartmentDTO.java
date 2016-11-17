package mis.dto.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bayurov
 * @link mis.directories.entities.Department
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentDTO extends DirectoryItemDTO {
  /** Сокращенное наименование */
  private String shortName;

  /** Полный адрес */
  private String fullAddress;

  /** Индивидуальный номер налогоплательщика */
  private String codeINN;

  /** Код причины постановки на учет */
  private String codeKPP;

  /** Основной государственный регистрационный номер */
  private String codeOGRN;

  /**
   * Код медицинского учреждения в Реестре НСИ. Справочник MDR308 (nsi.rosminzdrav)
   * Устанавливается при синхранизации подразделений с ЦОД
   */
  private String codeNSI;

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public void setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
  }

  public String getCodeINN() {
    return codeINN;
  }

  public void setCodeINN(String codeINN) {
    this.codeINN = codeINN;
  }

  public String getCodeKPP() {
    return codeKPP;
  }

  public void setCodeKPP(String codeKPP) {
    this.codeKPP = codeKPP;
  }

  public String getCodeOGRN() {
    return codeOGRN;
  }

  public void setCodeOGRN(String codeOGRN) {
    this.codeOGRN = codeOGRN;
  }

  public String getCodeNSI() {
    return codeNSI;
  }

  public void setCodeNSI(String codeNSI) {
    this.codeNSI = codeNSI;
  }
}
