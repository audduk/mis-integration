package mis.lis.prescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:44
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InstrumentalDTO extends BasePrescriptionDTO implements Serializable {
  /**
   * Набор лабораторных услуг
   */
  private ManipulationDTO manipulations;

  public InstrumentalDTO() {
  }

  public InstrumentalDTO(Long id, QueueItemDTO queueItem, UrgencyDTO urgency, String explanation, Calendar referralDate) {
    super(id, queueItem, urgency, explanation, referralDate);
  }

  public ManipulationDTO getManipulations() {
    return manipulations;
  }

  public void setManipulations(ManipulationDTO manipulations) {
    this.manipulations = manipulations;
  }
}

