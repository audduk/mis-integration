package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.RequestRoot;
import mis.integration.ariadna.exceptions.PrescriptionDataException;
import mis.lis.prescription.LabPrescriptionDTO;
import mis.lis.prescription.PatientDTO;
import mis.lis.prescription.PrescriptionDTO;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;

/**
 * Тестирование трансформера
 */
public class TransformerTest {
  @Test
  @Ignore
  public void testTransformation() throws PrescriptionDataException {
    final PrescriptionDTO dto = getPrescriptionDTO();
    final RequestRoot result = new Transformer().transformToRequestRoot(dto);
  }

  private PrescriptionDTO getPrescriptionDTO() {
    PrescriptionDTO dto = new PrescriptionDTO();
    dto.setDate(Calendar.getInstance());
    dto.setPrescription(new LabPrescriptionDTO());
    dto.getPrescription().setId(123L);

    fillPatient(dto);
    return dto;
  }

  private void fillPatient(PrescriptionDTO dto) {
    dto.setPatient(new PatientDTO());
    PatientDTO patient = dto.getPatient();
    patient.setId(1L);
    patient.setLastName("Иванов");
  }
}
