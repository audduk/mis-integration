package mis.integration.ariadna.exceptions;

/**
 * Ошибка в данных, полученных из ЛИС ({@link mis.integration.ariadna.data.Observation}
 */
public class ReportDataException extends AriadnaTransformationException {
  public ReportDataException(String message) {
    super(message);
  }
}
