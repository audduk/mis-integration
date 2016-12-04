package mis.integration.ariadna.exceptions;

import mis.integration.ariadna.data.Observation;

/**
 * Ошибка в данных, полученных из ЛИС ({@link mis.integration.ariadna.data.Observation})
 */
public class ReportDataException extends AriadnaTransformationException {
  private Observation observation;

  public Observation getObservation() {
    return observation;
  }

  public ReportDataException(String message, Observation observation) {
    super(message);
    this.observation = observation;
  }
}
