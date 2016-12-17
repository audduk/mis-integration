package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Обработка информации о словаре
 */
public abstract class AbstractVocProcessor {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  public abstract String tableName();
  public abstract String sequenceName();

  public String where() {
    return "";
  }

  public void process(List<BaseItem> itemList) {
    disableAllItems();
    if (itemList.size() == 0)
      return;;
    batchUpdate(itemList);

    final List<String> affectedCodes = getAffectedCodes(getCodes(itemList));
    final List<BaseItem> itemsToInsert = filterAffected(itemList, affectedCodes);
    if (itemsToInsert.size() > 0)
      batchInsert(itemsToInsert);
  }

  private List<String> getAffectedCodes(List<String> codeList) {
    List<String> result = new ArrayList<>();
    for (String code : codeList) {
      List<Map<String, Object>> rows = jdbcTemplate.queryForList(String.format("SELECT id FROM %s WHERE code = '%s'", tableName(), code));
      if (rows.size() > 0)
        result.add(code);
    }
    return result;
  }

  protected List<String> getCodes(List<BaseItem> itemList) {
    List<String> result = new ArrayList<>(itemList.size());
    for (BaseItem item : itemList)
      result.add(item.getId());
    return result;
  }

  protected List<BaseItem> filterAffected(List<BaseItem> itemList, List<String> codeList) {
    List<BaseItem> result = new ArrayList<>(itemList.size() - codeList.size());
    for (BaseItem anItemList : itemList) {
      if (!codeList.contains(anItemList.getId()))
        result.add(anItemList);
    }
    return result;
  }

  protected int[] batchUpdate(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format("UPDATE %s SET version=version+1, entityStatus=0, name=? where code=?", tableName()),
        new BatchStatementSetter(items) {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, items.get(i).getTitle());
            ps.setString(2, items.get(i).getId());
          }
        });
  }

  protected int[] batchInsert(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format(
            "INSERT INTO %s (id, version, entityStatus, ENTITY_UID, code, name) " +
                "VALUES (%s.NEXTVAL, 0, 0, ?, ?, ?)",
            tableName(), sequenceName()
        ),
        new BatchStatementSetter(items) {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, UUID.randomUUID().toString().toLowerCase());
            ps.setString(2, items.get(i).getId());
            ps.setString(3, items.get(i).getTitle());
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

  protected static abstract class BatchStatementSetter implements BatchPreparedStatementSetter {
    final List<BaseItem> items;

    BatchStatementSetter(List<BaseItem> items) {
      this.items = items;
    }

    @Override
    public int getBatchSize() {
      return items.size();
    }
  }
}
