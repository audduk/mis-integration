package mis.dto.common;

import mis.dto.AbstractDirectoryItemDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура, аналогичная справочнику для передачи данных в печать
 * @author Миловидов Андрей
 *         Date: 10.08.12
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectoryItemDTO extends AbstractDirectoryItemDto {
  /** Код элемента */
  @XmlElement
  private String code;

  /** Конструктор по умолчанию */
  public DirectoryItemDTO() {

  }

  public DirectoryItemDTO(Long id, String code, String name) {
    super(id, name);
    this.code = code;
  }

  /* Методы доступа */

  /**
   * Получение кода элемента справочника
   * @return code - Код элемента справочника
   */
  public String getCode() {
    return code;
  }

  /**
   * Установка кода элемента справочника
   * @param code Код элемента справочника
   */
  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DirectoryItemDTO))
      return false;
    DirectoryItemDTO other = (DirectoryItemDTO) obj;
    return this.getId() != null && this.getId().equals((other.getId()));
  }
}

