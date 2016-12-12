package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseItem;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
  public void process(List<BaseItem> itemList) {
    super.process(itemList);
    List<Pair<String, String>> specimens = new ArrayList<>(itemList.size() * 2);
    for (BaseItem service : itemList)
      for (BaseItem specimen : service.getSpecimens())
        specimens.add(Pair.of(service.getId(), specimen.getId()));
    if (specimens.size() > 0)
      updateSpecimens(specimens);
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
