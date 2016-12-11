package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseVocabulary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Тестирование обработчиков словарей
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProcessorsTest.Config.class)
public class ProcessorsTest extends AbstractAriadnaTest {
  @Configuration
  @ImportResource(locations = "classpath:datasource.xml")
  public static class Config {
    @Bean(name = "exploreVocProcessor")
    public AbstractVocProcessor exploreVocProcessor() {
      return new ExploreVocProcessor();
    }
  }

  private Unmarshaller unmarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(BaseVocabulary.class);
    unmarshaller = jc.createUnmarshaller();
  }

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private ExploreVocProcessor exploreVocProcessor;

  @Test
  public void testExploreVocProcessorSimple() throws JAXBException {
    BaseVocabulary voc = (BaseVocabulary) unmarshaller.unmarshal(getResourceAsStream("voc/explore.xml"));
    exploreVocProcessor.process(voc.getContents());
    Assert.assertEquals(3, JdbcTestUtils.countRowsInTable(jdbcTemplate, exploreVocProcessor.tableName()));
  }

  @Test
  public void testExploreVocProcessorComplex() throws JAXBException {
    final String tableName = exploreVocProcessor.tableName();
    JdbcTestUtils.deleteFromTables(jdbcTemplate, tableName);

    testExploreVocProcessorSimple();

    BaseVocabulary voc = (BaseVocabulary) unmarshaller.unmarshal(getResourceAsStream("voc/explore1.xml"));
    exploreVocProcessor.process(voc.getContents());
    Assert.assertEquals(2,
        JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, exploreVocProcessor.tableName(), "entityStatus=0"));
  }

}
