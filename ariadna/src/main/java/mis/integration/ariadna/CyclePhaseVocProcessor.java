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
  public void process(List<BaseItem> itemList) {
    for (BaseItem item : itemList)
      if ("4".equals(item.getId()))
        super.process(item.getItems());
  }
}
