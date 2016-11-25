package mis.integration.ariadna;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Тестовые запросы к приложению
 */
@RestController
public class TestController {
  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String test() {
    return "Hello!";
  }
}
