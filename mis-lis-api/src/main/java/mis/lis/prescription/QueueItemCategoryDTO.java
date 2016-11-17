package mis.lis.prescription;

import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author: petrov
 * Date: 08.08.13
 * Категория элемента живой очереди (по записи, льготный, экстренный, вип, без записи)
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QueueItemCategoryDTO extends AbstractEntityDto implements Serializable{
  /** Наименование очереди */
  private String name;

  /** Приоритет очереди сверху вниз */
  private Integer priority;

  /** Признак того, что смена по времени (бъется на свободные явки) */
  private Boolean byAppointment;

  public QueueItemCategoryDTO() {
  }

  public QueueItemCategoryDTO(String name, Integer priority, Boolean byAppointment) {
    this.name = name;
    this.priority = priority;
    this.byAppointment = byAppointment;
  }

  public QueueItemCategoryDTO(Long id, String name, Integer priority) {
    super(id);
    this.name = name;
    this.priority = priority;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Boolean getByAppointment() {
    return byAppointment;
  }

  public void setByAppointment(Boolean byAppointment) {
    this.byAppointment = byAppointment;
  }
}
