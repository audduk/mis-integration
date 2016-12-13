package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Обработка информации о словаре
 */
public abstract class AbstractVocProcessor {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  public abstract String tableName();

  public String where() {
    return "";
  }

  public void process(List<BaseItem> itemList) {
    disableAllItems();
    if (itemList.size() == 0)
      return;;
    int[] affectedList = batchUpdate(itemList);
    final List<BaseItem> itemsToInsert = filterAffected(itemList, affectedList);
    if (itemsToInsert.size() > 0)
      batchInsert(itemsToInsert);
  }

  protected List<BaseItem> filterAffected(List<BaseItem> itemList, int[] affectedList) {
    List<BaseItem> result = new ArrayList<>(itemList.size() - affectedList.length);
    for (int i = 0; i < itemList.size(); ++i) {
      if (affectedList[i] == 0)
        result.add(itemList.get(i));
    }
    return result;
  }

  protected int[] batchUpdate(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format("UPDATE %s SET version=version+1, entityStatus=0, name=? where code=?", tableName()),
        new BatchPreparedStatementSetter() {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, items.get(i).getTitle());
            ps.setString(2, items.get(i).getId());
          }

          public int getBatchSize() {
            return items.size();
          }
        });
  }

  protected int[] batchInsert(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format(
            "INSERT INTO %s (id, version, entityStatus, ENTITY_UID, code, name) " +
                "VALUES ((SELECT COUNT(id)+1 FROM %s), 0, 0, ?, ?, ?)",
            tableName(), tableName()
        ),
        new BatchPreparedStatementSetter() {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
//            ps.setLong(1, 0);
            ps.setString(1, UUID.randomUUID().toString().toLowerCase());
            ps.setString(2, items.get(i).getId());
            ps.setString(3, items.get(i).getTitle());
          }

          public int getBatchSize() {
            return items.size();
          }
        });
  }

    /** Деактивация всех словарных значений (по умолчанию всех записей таблицы {@link #tableName()}) */
  protected void disableAllItems() {
    String hideSql = String.format("UPDATE %s e SET entityStatus=1", tableName());
    if (!where().isEmpty())
      hideSql += " WHERE " + where();
    jdbcTemplate.update(hideSql);
  }
}
