package mis.integration.ariadna.war;

import java.io.File;
import java.io.InputStream;

/**
 * Общие методы для тестовых классов
 */
public abstract class AbstractAriadnaTest {
  /** Получение ресурсного файла в виле Stream */
  protected InputStream getResourceAsStream(String path) {
    return getClass().getClassLoader().getResourceAsStream("mis/integration/ariadna/" + path);
  }

  /** Получение ресурса в виде файла */
  protected final File getResourceFile(String path) {
    return new File(getClass().getClassLoader().getResource("mis/integration/ariadna/" + path).getFile());
  }

}
