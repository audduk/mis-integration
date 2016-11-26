package mis.lis.prescription;

import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:26
 * Абстрактный вид оплаты
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ContractDTO.class, OmsPolicyDTO.class, DmsPolicyDTO.class, VmpCouponDTO.class})
public class PaymentDTO extends AbstractEntityDto implements Serializable {
  public PaymentDTO() {
  }

  protected PaymentDTO(Long id) {
    super(id);
  }
}

