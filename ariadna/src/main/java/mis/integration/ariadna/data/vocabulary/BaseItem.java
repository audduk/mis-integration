package mis.integration.ariadna.data.vocabulary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Элемент словаря
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseItem {
  @XmlElement(name = "ID")
  private String id;
  @XmlElement(name = "Title")
  private String title;

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
}
