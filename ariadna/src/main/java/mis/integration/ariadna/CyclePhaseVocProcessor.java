package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseItem;

import java.util.List;

/**
 * Обработка содержимого словаря "Фазы цикла" (группа 4 условий CONDITION_GROUP)
 */
public class CyclePhaseVocProcessor extends AbstractVocProcessor {
  @Override
  public String tableName() {
    return "DIR_CYCLE_PHASE";
  }

  @Override
  public String sequenceName() {
    return "DIR_CYCLE_PHASE_ID_SEQ";
  }

  @Override
  public List<BaseItem> process(List<BaseItem> itemList) {
    for (BaseItem item : itemList)
      if ("4".equals(getCode(item)))
        return super.process(item.getItems());
    return null;
  }
}
