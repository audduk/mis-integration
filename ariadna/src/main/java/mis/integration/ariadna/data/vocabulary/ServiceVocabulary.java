package mis.integration.ariadna.data.vocabulary;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Cловарь "Услуги" ЛИС Ариадна.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ServiceList")
public class ServiceVocabulary {
  @XmlElement(name = "Service")
  private List<BaseItem> services;

  public List<BaseItem> getServices() {
    return services;
  }

  public void setServices(List<BaseItem> services) {
    this.services = services;
  }
}
