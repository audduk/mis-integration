package mis.dto.common;

import java.io.Serializable;

/** Abstract Entity Data Transfer Object */
public abstract class AbstractEntityDto implements Serializable, Cloneable {
  /** Serialization Version UID */
  private static final long serialVersionUID = 1L;
  /** Id */
  private Long id;

  public AbstractEntityDto() {
  }

  public AbstractEntityDto(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
