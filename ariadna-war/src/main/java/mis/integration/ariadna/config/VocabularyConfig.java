package mis.integration.ariadna.config;

import mis.integration.ariadna.AbstractVocProcessor;
import mis.integration.ariadna.CyclePhaseVocProcessor;
import mis.integration.ariadna.ExploreVocProcessor;
import mis.integration.ariadna.SpecimenVocProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VocabularyConfig {
  @Bean(name = "exploreVocProcessor")
  public AbstractVocProcessor exploreVocProcessor() {
    return new ExploreVocProcessor();
  }

  @Bean(name = "cyclePhaseProcessor")
  public AbstractVocProcessor cyclePhaseProcessor() {
    return new CyclePhaseVocProcessor();
  }

  @Bean(name = "specimenVocProcessor")
  public AbstractVocProcessor specimenVocProcessor() {
    return new SpecimenVocProcessor();
  }
}
