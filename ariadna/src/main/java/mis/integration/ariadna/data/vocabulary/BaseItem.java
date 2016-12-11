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
}
