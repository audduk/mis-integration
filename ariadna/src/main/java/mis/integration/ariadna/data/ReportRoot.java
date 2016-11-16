package mis.integration.ariadna.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * ДТО. Протокол проведения лабораторных исследований (ЛИ)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedapLisObservationReport")
public class ReportRoot {
  @XmlElement(name = "Observation")
  private List<Observation> observations;

  public List<Observation> getObservations() {
    return observations;
  }

  public void setObservations(List<Observation> observations) {
    this.observations = observations;
  }
}
