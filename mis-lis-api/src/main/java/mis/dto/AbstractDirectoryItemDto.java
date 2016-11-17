package mis.dto;

import mis.dto.common.AbstractEntityDto;

import java.io.Serializable;

/**
 * Abstract Directory Item Data Transfer Object
 */
public abstract class AbstractDirectoryItemDto extends AbstractEntityDto implements Serializable {
  /** Name */
  private String name;
  /** Parent Id */
  private Long parentId;

  /** Конструктор по умолчанию */
  public AbstractDirectoryItemDto() {

  }

  public AbstractDirectoryItemDto(Long id, String name) {
    super(id);
    this.name = name;
  }

  /**
   * Получение наименование элемента справочника
   * @return  name - Наименование элемента справочника
   */
  public String getName() {
    return name;
  }

  /**
   * Установка наименование элемента справочника
   * @param name - Наименование элемента справочника
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Получение id родителя
   * @return Id родителя
   */
  public Long getParentId() {
    return parentId;
  }

  /**
   * Установка id родителя
   * @param parentId Id родителя
   */
  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }
}
