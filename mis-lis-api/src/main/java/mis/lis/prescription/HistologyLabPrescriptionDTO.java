package mis.lis.prescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:45
 * Направление на гисто/цито обследование
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HistologyLabPrescriptionDTO extends LabPrescriptionDTO implements Serializable {
  /**
   * Описание материала
   */
  private String materialDescription;
  /**
   * Размер материала
   */
  private String materialSize;
  /**
   * Что надо сделать
   */
  private String therapy;
  /**
   * Признак доктора
   */
  private Integer doctorFlag;

  public HistologyLabPrescriptionDTO() {
  }

  public HistologyLabPrescriptionDTO(String materialDescription, String materialSize, String therapy, Integer doctorFlag) {
    this.materialDescription = materialDescription;
    this.materialSize = materialSize;
    this.therapy = therapy;
    this.doctorFlag = doctorFlag;
  }

  public String getMaterialDescription() {
    return materialDescription;
  }

  public void setMaterialDescription(String materialDescription) {
    this.materialDescription = materialDescription;
  }

  public String getMaterialSize() {
    return materialSize;
  }

  public void setMaterialSize(String materialSize) {
    this.materialSize = materialSize;
  }

  public String getTherapy() {
    return therapy;
  }

  public void setTherapy(String therapy) {
    this.therapy = therapy;
  }

  public Integer getDoctorFlag() {
    return doctorFlag;
  }

  public void setDoctorFlag(Integer doctorFlag) {
    this.doctorFlag = doctorFlag;
  }
}

