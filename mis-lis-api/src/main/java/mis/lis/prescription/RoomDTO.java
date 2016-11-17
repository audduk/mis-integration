package mis.lis.prescription;

import mis.dto.common.DirectoryItemDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: prokofiev
 * Date: 23.05.12
 * Time: 17:27
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomDTO extends DirectoryItemDTO implements Serializable {
  private String floor;

  public RoomDTO() {
  }

  public RoomDTO(Long id, String code, String name, String floor) {
    super(id, code, name);
    this.floor = floor;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }
}

