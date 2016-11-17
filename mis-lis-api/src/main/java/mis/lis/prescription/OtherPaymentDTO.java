package mis.lis.prescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Date: 04.02.13
 * Другие виды оплаты медицинских услуг
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherPaymentDTO extends PaymentDTO implements Serializable {

  private String description;

  public OtherPaymentDTO() {
  }

  public OtherPaymentDTO(Long id, String description) {
    super(id);
    this.description = description;

  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
