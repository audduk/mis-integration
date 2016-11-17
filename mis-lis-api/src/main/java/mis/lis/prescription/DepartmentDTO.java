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
 * Подразделение
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentDTO extends DirectoryItemDTO implements Serializable {
  public DepartmentDTO() {
  }

  public DepartmentDTO(Long id, String code, String name) {
    super(id, code, name);
  }
}

