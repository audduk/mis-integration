package mis.integration.ariadna;

import mis.dto.common.DirectoryItemDTO;
import mis.integration.ariadna.data.*;
import mis.integration.ariadna.exceptions.PrescriptionDataException;
import mis.lis.prescription.*;

import java.util.*;

/**
 * Преобразование назначения ({@link PrescriptionDTO} в структуру заказа ЛИ ЛИС ({@link RequestRoot})
 */
public class PrescriptionTransformer {
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
    final DirectoryItemDTO diagnosis = prescription.getDiagnosis();
    if (diagnosis != null)
      observation.setDiagnosis(diagnosis.getCode());
    final Set<BiomaterialDTO> biomaterials = prescription.getBiomaterials();
    if (biomaterials == null || biomaterials.isEmpty()) {
      ;//throw new PrescriptionDataException("Не задан биоматериал"); //временно отключаем проверку (МИС может отсылать пустой биоматериал)
    } else {
      final BiomaterialDTO biomaterial = biomaterials.iterator().next();
      observation.setSpecimenTypeID(Long.valueOf(biomaterial.getCode()));
      observation.setSpecimenType(biomaterial.getName());
    }
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
    fillPatientCondition(patient, dto);
    return patient;
  }

  private OrderingInstitution getInstitution(DepartmentDTO department) {
    final OrderingInstitution result = new OrderingInstitution();
    if (department != null) {
      result.setId(Long.valueOf(department.getCode()));
      result.setFullName(department.getName());
    }
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

  private void fillPatientCondition(Patient patient, PrescriptionDTO dto) {
    if (dto.getPrescription().getPatientResume() instanceof PatientFemaleResumeDTO) {
      PatientFemaleResumeDTO resume = (PatientFemaleResumeDTO) dto.getPrescription().getPatientResume();
      if (resume.getCyclePhase() != null) {
        patient.setConditionID(resume.getCyclePhase().getCode());
        patient.setCondition(resume.getCyclePhase().getName());
        return;
      }
      if (resume.getPregnancyMax() != null) {
        final Integer week = getPregnancyWeek(resume.getPregnancyMax());
        if (week > 42)
          return;
        patient.setConditionID(Integer.toString(6 + (week-1)));
        patient.setCondition(String.format("Беременность %d неделя", week));
      }
    }
  }

  public static Integer getPregnancyWeek(Integer daysMax) {
    return (daysMax / 7) + 1;
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
