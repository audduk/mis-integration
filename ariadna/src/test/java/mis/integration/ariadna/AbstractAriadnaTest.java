package mis.integration.ariadna;

import java.io.InputStream;

/**
 * Общие методы для тестовых классов
 */
public abstract class AbstractAriadnaTest {
  /** Получение ресурсного файла в виле Stream */
  protected InputStream getResourceAsStream(String path) {
    return getClass().getClassLoader().getResourceAsStream("mis/integration/ariadna/" + path);
  }
}
