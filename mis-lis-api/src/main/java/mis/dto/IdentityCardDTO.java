package mis.dto;

import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Объект для передачи информации об удостоверении личности
 * Date: 14.12.12
 * Time: 10:02
 * @author Миловидов Андрей
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentityCardDTO {
  @XmlElement
  private DirectoryItemDTO type;

  /** Серия документа */
  @XmlElement
  private String series;

  /** Номер документа */
  @XmlElement
  private String number;

  /** Дата выдачи */
  @XmlElement
  private Date date;

  /** Орган, выдавший документ */
  @XmlElement
  private String authority;

  public DirectoryItemDTO getType() {
    return type;
  }

  public void setType(DirectoryItemDTO type) {
    this.type = type;
  }

  public void setIdentityType(DirectoryItemDTO type) {
    this.type = type;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}
