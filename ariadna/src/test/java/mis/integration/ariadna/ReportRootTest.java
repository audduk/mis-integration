package mis.integration.ariadna;

import mis.integration.ariadna.data.Observation;
import mis.integration.ariadna.data.ReportGroup;
import mis.integration.ariadna.data.ReportRoot;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Тестирование xml-маппинга класса "Протокол проведения ЛИ"
 * @see ReportRoot
 */
public class ReportRootTest extends AbstractAriadnaTest {

  private Unmarshaller unmarshaller;

  @Before
  public void init() throws Exception {
    JAXBContext jc = JAXBContext.newInstance(ReportRoot.class);
    unmarshaller = jc.createUnmarshaller();
  }

  @Test
  public void RequestXmlBindTest() throws Exception {
    ReportRoot report = (ReportRoot) unmarshaller.unmarshal(getResourceAsStream("reports/15350001.xml"));
    final List<Observation> observations = report.getObservations();
    assertNotNull("Задание на проведение ЛИ не заполнено", observations);
    assertEquals("Задание на проведение ЛИ не заполнено", observations.size(), 1);
    final List<ReportGroup> reportGroups = observations.get(0).getReportGroups();
    assertEquals("Отчет о проведении ЛИ не заполнен", reportGroups.size(), 1);
    assertEquals("Результаты проведения ЛИ (тесты) не заполнен", reportGroups.get(0).getResults().size(), 2);
  }
}
