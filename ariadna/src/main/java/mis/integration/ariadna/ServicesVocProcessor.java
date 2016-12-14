package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseItem;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Обработка содержимого словаря "Услуги" ({@link mis.integration.ariadna.data.vocabulary.ServiceVocabulary})
 */
public class ServicesVocProcessor extends AbstractVocProcessor {
  @Override
  public String tableName() {
    return "DIR_MED_SIMPLE_SERVICE";
  }

  @Override
  public String where() {
    return String.format(" e.fType_id = %d", fTypeId);
  }

  private Long fTypeId = -1L;

  @PostConstruct
  private void init() {
    List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT id FROM DIR_MED_SIMPLE_SERVICE_FTYPE WHERE code = '02'");
    if (rows.size() > 0)
      fTypeId = (Long) rows.get(0).get("id");
  }

  @Override
  public void process(List<BaseItem> itemList) {
    super.process(itemList);
    List<Pair<String, String>> specimens = new ArrayList<>(itemList.size() * 2);
    for (BaseItem service : itemList)
      for (BaseItem specimen : service.getSpecimens())
        specimens.add(Pair.of(service.getId(), specimen.getId()));
    if (specimens.size() > 0)
      updateSpecimens(specimens);
  }

  @Override
  protected int[] batchUpdate(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format("UPDATE %s SET version=version+1, entityStatus=0, name=?, shortname=? where code=?", tableName()),
        new BatchStatementSetter(items) {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, items.get(i).getTitle());
            ps.setString(2, items.get(i).getTitle());
            ps.setString(3, items.get(i).getId());
          }
        });
  }

  @Override
  protected int[] batchInsert(final List<BaseItem> items) {
    return jdbcTemplate.batchUpdate(
        String.format(
            "INSERT INTO %s (id, version, entityStatus, ENTITY_UID, code, name, shortname, fType_id) " +
                "VALUES ((SELECT COUNT(id)+1 FROM %s), 0, 0, ?, ?, ?, ?, ?)",
            tableName(), tableName()
        ),
        new BatchStatementSetter(items) {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, UUID.randomUUID().toString().toLowerCase());
            ps.setString(2, items.get(i).getId());
            ps.setString(3, items.get(i).getTitle());
            ps.setString(4, items.get(i).getTitle());
            ps.setLong(5, fTypeId);
          }
        });
  }

  private void updateSpecimens(final List<Pair<String, String>> specimens) {
    jdbcTemplate.execute("DELETE FROM LINK_A_BIOMATERIALS");
    jdbcTemplate.batchUpdate(
        "INSERT INTO LINK_A_BIOMATERIALS (A_SERVICE_ID, BIOMATERIAL_ID) VALUES (" +
            "(SELECT ID FROM DIR_MED_SIMPLE_SERVICE WHERE CODE=?)," +
            "(SELECT ID FROM DIR_BIOMATERIALS WHERE CODE=?))",
        new BatchPreparedStatementSetter() {
          public void setValues(PreparedStatement ps, int i) throws SQLException {
            ps.setString(1, specimens.get(i).getFirst());
            ps.setString(2, specimens.get(i).getSecond());
          }

          public int getBatchSize() {
            return specimens.size();
          }
        });
  }
}
