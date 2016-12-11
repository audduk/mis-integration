package mis.integration.ariadna.config;

import mis.integration.ariadna.AbstractVocProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VocabularyConfig {
  @Bean(name = "exploreVocProcessor")
  public AbstractVocProcessor exploreVocProcessor() {
    return new AbstractVocProcessor();
  }
}
