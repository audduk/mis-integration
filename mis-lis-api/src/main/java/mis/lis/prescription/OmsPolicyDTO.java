package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 24.05.12
 * Time: 9:46
 * Полис обязательного медицинского страхования
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OmsPolicyDTO extends PaymentDTO implements Serializable {
  /**
   * Серия
   */
  private String series;
  /**
   * Номер
   */
  private String number;
  /**
   * Дата начала срока действия
   */
  private Calendar beginDate;
  /**
   * Дата окончания срока действия
   */
  private Calendar endDate;
  /**
   * Страховая компания
   */
  private DirectoryItemDTO company;

  public OmsPolicyDTO() {
  }

  public OmsPolicyDTO(Long id, String series, String number, Calendar beginDate, Calendar endDate) {
    super(id);
    this.series = series;
    this.number = number;
    this.beginDate = beginDate;
    this.endDate = endDate;
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

  public Calendar getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Calendar beginDate) {
    this.beginDate = beginDate;
  }

  public Calendar getEndDate() {
    return endDate;
  }

  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  public DirectoryItemDTO getCompany() {
    return company;
  }

  public void setCompany(DirectoryItemDTO company) {
    this.company = company;
  }
}

