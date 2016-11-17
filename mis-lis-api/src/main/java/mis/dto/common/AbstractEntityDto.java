package mis.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/** Abstract Entity Data Transfer Object */
@Getter
@Setter
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
}
