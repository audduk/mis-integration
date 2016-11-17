package mis.lis.prescription;

import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:42
 * Элемент очереди
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QueueItemDTO extends AbstractEntityDto implements Serializable {
  /**
   * Кабинет
   */
  private RoomDTO room;

  /**
   * К кому направлен
   */
  private EmployeeDTO doctor;

  /**
   * Категория элемента живой очереди (по записи, льготный, экстренный, вип, без записи)
   */
  private QueueItemCategoryDTO queueItemCategory;

  public QueueItemDTO() {
  }

  protected QueueItemDTO(Long id, RoomDTO room, EmployeeDTO doctor, StaffAppointmentDTO appointment, QueueItemCategoryDTO queueItemCategory) {
    super(id);
    this.room = room;
    this.doctor = doctor;
    this.queueItemCategory = queueItemCategory;
  }

  public RoomDTO getRoom() {
    return room;
  }

  public void setRoom(RoomDTO room) {
    this.room = room;
  }

  public EmployeeDTO getDoctor() {
    return doctor;
  }

  public void setDoctor(EmployeeDTO doctor) {
    this.doctor = doctor;
  }

  public QueueItemCategoryDTO getQueueItemCategory() {
    return queueItemCategory;
  }

  public void setQueueItemCategory(QueueItemCategoryDTO queueItemCategory) {
    this.queueItemCategory = queueItemCategory;
  }
}

