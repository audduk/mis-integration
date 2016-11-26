package mis.integration.ariadna;

import mis.dto.common.DirectoryItemDTO;
import mis.integration.ariadna.data.*;
import mis.integration.ariadna.exceptions.PrescriptionDataException;
import mis.lis.prescription.*;
import mis.lis.report.Report;

import java.util.*;

/**
 * Преобразование {@link Observation} в структуру протокола ЛИ МИС ({@link Report})
 */
public class Transformer {
  public List<Report> transformToReport(Observation observation) {
    final List<Report> result = new ArrayList<>();
    if (observation.getReportGroups() == null)
      return result;
    for (ReportGroup group : observation.getReportGroups()) {
      result.add(new Report());
      result.add(new Report());
    }
    return result;
  }

  public RequestRoot transformToRequestRoot(PrescriptionDTO prescription) throws PrescriptionDataException {
    try {
      final Observation observation = getObservation(prescription);
      final RequestRoot requestRoot = new RequestRoot();
      requestRoot.setObservations(Arrays.asList(observation));
      return requestRoot;
    } catch (PrescriptionDataException e) {
      throw new PrescriptionDataException(prescription.getPrescription().getId().toString() + ". " + e.getMessage());
    }
  }

  private Observation getObservation(PrescriptionDTO source) throws PrescriptionDataException {

    final LabPrescriptionDTO prescription = (LabPrescriptionDTO) source.getPrescription();

    final Observation observation = new Observation();
    observation.setId(prescription.getId());
    observation.setRegDate(source.getDate());
    observation.setMisOrderID(prescription.getId().toString());
    observation.setOrderID(prescription.getId().toString());
    //observation.setOrderDate();//не заполняем (по согласованию с Ариадна)
    final Set<BiomaterialDTO> biomaterials = prescription.getBiomaterials();
    if (biomaterials == null || biomaterials.isEmpty())
      throw new PrescriptionDataException("Не задан биометериал");
    final BiomaterialDTO biomaterial = biomaterials.iterator().next();
    observation.setSpecimenTypeID(Long.valueOf(biomaterial.getCode()));
    observation.setSpecimenType(biomaterial.getName());
    final BiomaterialTakingPlaceDTO takingPlaceDTO = prescription.getBiomaterialTakingPlace();
    if (takingPlaceDTO != null) {
      observation.setSpecimenSiteID(Long.valueOf(takingPlaceDTO.getCode()));
      observation.setSpecimenSite(takingPlaceDTO.getName());
    }
    observation.setCito(getCito(prescription.getUrgency()));
    if (prescription.getResearchTarget() != null) {
      observation.setPurposeID(prescription.getResearchTarget().getId());
      observation.setPurpose(prescription.getResearchTarget().getName());
    }
    observation.setMessage(prescription.getAdditionalParameters());
    observation.setPatient(getPatient(source));
    observation.setInstitution(getInstitution(source.getDepartment()));
    observation.setOrderItems(getOrderItems(prescription.getManipulations()));
    return observation;
  }

  private Patient getPatient(PrescriptionDTO dto) throws PrescriptionDataException {
    final PatientDTO patientDTO = dto.getPatient();
    if (patientDTO == null)
      throw new PrescriptionDataException("Не задано поле 'patient'");
    final Patient patient = new Patient();
    patient.setMisId(patientDTO.getId().toString());
    patient.setGivenName(patientDTO.getFirstName());
    patient.setFamilyName(patientDTO.getLastName());
    patient.setMiddleName(patientDTO.getMiddleName());
    patient.setAddress(patientDTO.getResidenceAddress());
    patient.setPhone(null);
    patient.setCellularPhone(null);
    patient.setRelativePhone(null);
    patient.setGender(getGender(patientDTO.getSex()));
    patient.setBirthDate(patientDTO.getBirthDate());
    patient.setRegDate(null);
    fillPatientCondition(dto);
    return patient;
  }

  private OrderingInstitution getInstitution(DepartmentDTO department) {
    final OrderingInstitution result = new OrderingInstitution();
    result.setId(Long.valueOf(department.getCode()));
    result.setFullName(department.getName());
    return result;
  }

  private List<OrderItem> getOrderItems(Collection<ManipulationDTO> manipulations) throws PrescriptionDataException {
    if (manipulations == null || manipulations.isEmpty())
      throw new PrescriptionDataException("Не заданы услуги");
    final List<OrderItem> result = new ArrayList<>(manipulations.size());
    for (ManipulationDTO dto : manipulations) {
      final OrderItem item = new OrderItem();
      item.setServiceID(dto.getId());
      item.setService(dto.getName());
      item.setServiceCode(dto.getCode());
      result.add(item);
    }
    return result;
  }

  //TODO !!!
  private void fillPatientCondition(PrescriptionDTO dto) {

  }

  private String getGender(DirectoryItemDTO sex) {
    if (sex == null)
      return " ";
    return "1".equals(sex.getCode()) ? "M" : "F";
  }

  private Boolean getCito(UrgencyDTO urgency) {
    return urgency != null && !"NORMAL".equals(urgency.getCode());
  }
}
