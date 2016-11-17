package mis.dto.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Структура, аналогичная иерархическому справочнику для передачи данных
 * @author Миловидов Андрей
 *         Date: 10.08.12
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchicalDirectoryItemDTO extends DirectoryItemDTO {
  /** Детишки */
  @XmlElement
  private List<DirectoryItemDTO> children;

  /** Конструктор по умолчанию */
  public HierarchicalDirectoryItemDTO() {

  }

  public HierarchicalDirectoryItemDTO(Long id, String code, String name) {
    super(id,code, name);
  }

  /* Методы доступа */

  public List<DirectoryItemDTO> getChildren() {
    return children;
  }

  public void setChildren(List<DirectoryItemDTO> children) {
    this.children = children;
  }
}

