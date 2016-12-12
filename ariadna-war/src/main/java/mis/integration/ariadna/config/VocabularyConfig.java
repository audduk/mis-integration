package mis.integration.ariadna.config;

import mis.integration.ariadna.*;
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

  @Bean(name = "servicesVocProcessor")
  public AbstractVocProcessor servicesVocProcessor() {
    return new ServicesVocProcessor();
  }
}
