package mis.integration.ariadna.data.vocabulary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Элемент словаря
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseItem {
  @XmlElement(name = "ID")
  private String id;
  @XmlElement(name = "Title")
  private String title;
  @XmlElementWrapper(name = "CONDITION")
  @XmlElement(name = "item")
  private List<BaseItem> items; // расширение для словаря "Группа состояний пациента" (CONDITION_GROUP)
  @XmlElementWrapper(name = "SpecimenTypes")
  @XmlElement(name = "SpecimenType")
  private List<BaseItem> specimens; // расширение для словаря "Услуги" (Services)

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<BaseItem> getItems() {
    return items;
  }

  public void setItems(List<BaseItem> items) {
    this.items = items;
  }

  public List<BaseItem> getSpecimens() {
    return specimens;
  }

  public void setSpecimens(List<BaseItem> specimens) {
    this.specimens = specimens;
  }
}
