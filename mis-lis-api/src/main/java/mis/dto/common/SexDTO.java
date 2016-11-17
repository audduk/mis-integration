package mis.dto.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bayurov
 * @link mis.directories.entities.Sex
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SexDTO extends DirectoryItemDTO {

  private String alias;

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }
}
