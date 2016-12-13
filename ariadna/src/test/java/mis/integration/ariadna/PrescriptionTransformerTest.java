package mis.integration.ariadna;

import mis.integration.ariadna.data.RequestRoot;
import mis.integration.ariadna.exceptions.PrescriptionDataException;
import mis.lis.prescription.*;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Calendar;
import java.util.HashSet;

import static mis.integration.ariadna.PrescriptionTransformer.getPregnancyWeek;
import static org.junit.Assert.assertEquals;

/**
 * Тестирование трансформера
 */
public class PrescriptionTransformerTest {

  private Marshaller reportMarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(PrescriptionDTO.class);
    reportMarshaller = jc.createMarshaller();
  }

  @Test
  public void testWeekCalc() {
    assertEquals((long) 1, (long) getPregnancyWeek(1));
    assertEquals((long) 2, (long) getPregnancyWeek(7));
    assertEquals((long) 2, (long) getPregnancyWeek(8));
    assertEquals((long) 3, (long) getPregnancyWeek(14));
  }

  @Test
  public void testTransformation() throws PrescriptionDataException, JAXBException {
    final PrescriptionDTO dto = getPrescriptionDTO();
    final RequestRoot result = new PrescriptionTransformer().transformToRequestRoot(dto);
//
//    final StringWriter writer= new StringWriter();
//    reportMarshaller.marshal(dto, writer);
//    System.out.println(writer.toString());
  }

  private PrescriptionDTO getPrescriptionDTO() {
    PrescriptionDTO dto = new PrescriptionDTO();
    dto.setDate(Calendar.getInstance());
    dto.setPrescription(getPrescription());

    fillPatient(dto);
    return dto;
  }

  private BasePrescriptionDTO getPrescription() {
    final LabPrescriptionDTO dto = new LabPrescriptionDTO();
    dto.setId(123L);
    dto.setManipulations(new HashSet<ManipulationDTO>(2));
    dto.getManipulations().add(newManipulation(1L, "Л933006", "Глюкоза в моче (количественный)"));
    dto.getManipulations().add(newManipulation(2L, "Л933007", "Глюкоза в моче ()"));
    dto.setBiomaterials(new HashSet<BiomaterialDTO>(1));
    dto.getBiomaterials().add(newBiomaterial(1L, "5", "Моча"));
    return dto;
  }

  private BiomaterialDTO newBiomaterial(long id, String code, String name) {
    BiomaterialDTO dto = new BiomaterialDTO();
    dto.setId(id);
    dto.setCode(code);
    dto.setName(name);
    return dto;
  }

  private ManipulationDTO newManipulation(Long id, String code, String name) {
    ManipulationDTO result = new ManipulationDTO();
    result.setId(id);
    result.setCode(code);
    result.setName(name);
    return result;
  }

  private void fillPatient(PrescriptionDTO dto) {
    dto.setPatient(new PatientDTO());
    PatientDTO patient = dto.getPatient();
    patient.setId(1L);
    patient.setLastName("Иванов");
  }
}
