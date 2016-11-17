package mis.lis.prescription;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Calendar;

/**
 * User: prokofiev
 * Date: 22.05.12
 * Time: 12:14
 * Класс содержит набор данных для отправки в ЛИС по направлению на исследования
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescriptionDTO implements Serializable {
  /**
   * Статус Элемента
   */
  private PrescriptionStatus status;
  /**
   * Название направления
   */
  private String name;
  /**
   * Пациент
   */
  private PatientDTO patient;
  /**
   * Направивший врач
   */
  private EmployeeDTO doctor;
  /**
   * Кабинет
   */
  private RoomDTO room;
  /**
   * Подразделение
   */
  private DepartmentDTO department;

  /**
   * Признак того, что пациент находится в реанимации
   */
  private Boolean reanimation = false;
  /**
   * Дата создания направления
   */
  private Calendar date;
  /**
   * Идентификатор ЭПМЗ
   */
  private Long healthRecordId;
  /**
   * Направление
   */
  private BasePrescriptionDTO prescription;
  /**
   * Вид оплаты
   */
  private PaymentDTO payment;
  /**
   * Признак оплаты
   */
  private Boolean payed;

  /**
   * Лабораторное подразделение
   */
  private DepartmentDTO laboratoryDepartment;


  public PrescriptionDTO() {
  }

  public PrescriptionDTO(PrescriptionStatus status, String name, PatientDTO patient, EmployeeDTO doctor,
                         RoomDTO room, DepartmentDTO department, Calendar date, Long healthRecordId,
                         BasePrescriptionDTO prescription, PaymentDTO payment, Boolean payed,
                         DepartmentDTO laboratoryDepartment) {
    this.status = status;
    this.name = name;
    this.patient = patient;
    this.doctor = doctor;
    this.room = room;
    this.department = department;
    this.date = date;
    this.healthRecordId = healthRecordId;
    this.prescription = prescription;
    this.payment = payment;
    this.payed = payed;
    this.laboratoryDepartment = laboratoryDepartment;
  }

  public PrescriptionStatus getStatus() {
    return status;
  }

  public void setStatus(PrescriptionStatus status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatientDTO getPatient() {
    return patient;
  }

  public void setPatient(PatientDTO patient) {
    this.patient = patient;
  }

  public EmployeeDTO getDoctor() {
    return doctor;
  }

  public void setDoctor(EmployeeDTO doctor) {
    this.doctor = doctor;
  }

  public RoomDTO getRoom() {
    return room;
  }

  public void setRoom(RoomDTO room) {
    this.room = room;
  }

  public DepartmentDTO getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentDTO department) {
    this.department = department;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public Long getHealthRecordId() {
    return healthRecordId;
  }

  public void setHealthRecordId(Long healthRecordId) {
    this.healthRecordId = healthRecordId;
  }

  public BasePrescriptionDTO getPrescription() {
    return prescription;
  }

  public void setPrescription(BasePrescriptionDTO prescription) {
    this.prescription = prescription;
  }

  public PaymentDTO getPayment() {
    return payment;
  }

  public void setPayment(PaymentDTO payment) {
    this.payment = payment;
  }

  public Boolean getPayed() {
    return payed;
  }

  public void setPayed(Boolean payed) {
    this.payed = payed;
  }

  public DepartmentDTO getLaboratoryDepartment() {
    return laboratoryDepartment;
  }

  public void setLaboratoryDepartment(DepartmentDTO laboratoryDepartment) {
    this.laboratoryDepartment = laboratoryDepartment;
  }

  public Boolean getReanimation() {
    return reanimation;
  }

  public void setReanimation(Boolean reanimation) {
    this.reanimation = reanimation;
  }
}

