package mis.integration.ariadna;

import mis.integration.ariadna.data.vocabulary.BaseVocabulary;
import mis.integration.ariadna.data.vocabulary.ServiceVocabulary;
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
@ContextConfiguration(classes = ServicesProcessorsTest.Config.class)
public class ServicesProcessorsTest extends AbstractAriadnaTest {
  @Configuration
  @ImportResource(locations = "classpath:services-datasource.xml")
  public static class Config {
    @Bean(name = "specimenVocProcessor")
    public AbstractVocProcessor specimenVocProcessor() {
      return new SpecimenVocProcessor();
    }

    @Bean(name = "servicesVocProcessor")
    public AbstractVocProcessor servicesVocProcessor() {
      return new ServicesVocProcessor();
    }
  }

  private Unmarshaller unmarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(BaseVocabulary.class, ServiceVocabulary.class);
    unmarshaller = jc.createUnmarshaller();
  }

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private SpecimenVocProcessor specimenVocProcessor;
  @Autowired
  private ServicesVocProcessor servicesVocProcessor;

  @Test
  public void testServiceVocProcessor() throws JAXBException {
    // выполняем начальную загрузку словаря "Биоматериалы"
    BaseVocabulary voc = (BaseVocabulary) unmarshaller.unmarshal(getResourceAsStream("voc/specimens.xml"));
    specimenVocProcessor.process(voc.getContents());
    Assert.assertEquals(17, JdbcTestUtils.countRowsInTable(jdbcTemplate, specimenVocProcessor.tableName()));
    // выполняем загрузку словаря "Услуги"
    ServiceVocabulary serviceVocabulary = (ServiceVocabulary) unmarshaller.unmarshal(getResourceAsStream("voc/services.xml"));
    servicesVocProcessor.process(serviceVocabulary.getServices());
    assertDataBaseState();
    //при повторной загрузке не должно ничего поменяться
    servicesVocProcessor.process(serviceVocabulary.getServices());
    assertDataBaseState();
  }

  private void assertDataBaseState() {
    Assert.assertEquals(97, JdbcTestUtils.countRowsInTable(jdbcTemplate, servicesVocProcessor.tableName()));
    Assert.assertEquals(97, JdbcTestUtils.countRowsInTable(jdbcTemplate, "LINK_A_BIOMATERIALS"));
    Assert.assertEquals(97, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, servicesVocProcessor.tableName(), "fType_id=1"));
    Assert.assertEquals(97, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, servicesVocProcessor.tableName(), "name = shortname"));
  }

  @Test
  public void testServiceVocUnmarshaller() throws JAXBException {
    ServiceVocabulary voc = (ServiceVocabulary) unmarshaller.unmarshal(getResourceAsStream("voc/services.xml"));
    Assert.assertEquals(103, voc.getServices().size());
  }
}
