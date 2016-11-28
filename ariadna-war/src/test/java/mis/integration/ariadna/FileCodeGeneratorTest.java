package mis.integration.ariadna;

import org.junit.Before;
import org.junit.Test;

/**
 * Тестирование алгоритма генерации идентификатора файла
 */
public class FileCodeGeneratorTest {

  private FileCodeGenerator generator;

  @Before
  public void init() {
    generator = new FileCodeGenerator();
  }

  @Test
  public void testComputeValue() {
    for (int i=0; i < 36; ++i)
      System.out.println(generator.computeValue(null));
  }
}
