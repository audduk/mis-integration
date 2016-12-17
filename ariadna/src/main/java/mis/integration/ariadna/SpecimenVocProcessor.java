package mis.integration.ariadna;

/**
 * Обработка словаря "Тип материала"
 */
public class SpecimenVocProcessor extends AbstractVocProcessor {
  @Override
  public String tableName() {
    return "DIR_BIOMATERIALS";
  }

  @Override
  public String sequenceName() {
    return "DIR_BIOMATERIAL_ID_SEQ";
  }
}
