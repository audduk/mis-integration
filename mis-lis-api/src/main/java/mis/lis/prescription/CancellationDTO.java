package mis.lis.prescription;

import lombok.Getter;
import lombok.Setter;
import mis.dto.common.AbstractEntityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

/**
 * @author: petrov
 * Date: 27.12.13
 * Time: 11:15
 * Отмена направления
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class CancellationDTO extends AbstractEntityDto {

  /**
   * Идентификатор направления
   */
  @XmlElement
  Long requestID;
  /**
   * Информация о сотруднике
   */
  @XmlElement
  EmployeeDTO employee;

  /**
   * Основание для отмены направления
   */
  @XmlElement
  String basis;

  /**
   * Дата отмены направления
   */
  @XmlElement
  Calendar date;
}
