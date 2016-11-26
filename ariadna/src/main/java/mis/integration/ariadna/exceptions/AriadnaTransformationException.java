package mis.integration.ariadna.exceptions;

/**
 * Ошибка преобразования данных при передаче в (из) ЛИС Ариадна
 */
public abstract class AriadnaTransformationException extends Exception {
  public AriadnaTransformationException(String message) {
    super(message);
  }
}
