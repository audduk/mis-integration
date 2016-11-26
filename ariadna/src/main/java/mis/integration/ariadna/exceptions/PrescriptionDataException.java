package mis.integration.ariadna.exceptions;

/**
 * Ошибка в данных, передаваемых из МИС ({@link mis.lis.prescription.PrescriptionDTO}
 */
public class PrescriptionDataException extends AriadnaTransformationException {
  public PrescriptionDataException(String message) {
    super(message);
  }
}
