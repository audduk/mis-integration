package mis.integration.ariadna;

/**
 * Обработка словаря "Цель исследований"
 */
public class ExploreVocProcessor extends AbstractVocProcessor {
  @Override
  public String tableName() {
    return "DIR_RESEARCH_TARGET";
  }
}
