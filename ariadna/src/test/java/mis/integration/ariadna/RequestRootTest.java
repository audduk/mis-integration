package mis.integration.ariadna;

import mis.integration.ariadna.data.RequestRoot;
import mis.integration.ariadna.data.adapters.DateAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Тестирование xml-маппинга класса "Задание на проведение ЛИ"
 * @see RequestRoot
 */
public class RequestRootTest extends AbstractAriadnaTest {

  private Unmarshaller unmarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(RequestRoot.class);
    unmarshaller = jc.createUnmarshaller();
    unmarshaller.setAdapter(new DateAdapter());
  }

  @Test
  public void RequestXmlBindTest() throws Exception {
    RequestRoot request = (RequestRoot) unmarshaller.unmarshal(getResourceAsStream("requests/15296003.xml"));
    Assert.assertNotNull("Задание на проведение ЛИ не заполнено", request.getObservations());
  }
}
