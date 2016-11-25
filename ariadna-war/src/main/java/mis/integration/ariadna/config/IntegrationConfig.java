package mis.integration.ariadna.config;

import mis.integration.ariadna.Transformer;
import mis.lis.prescription.PrescriptionDTO;
import mis.lis.report.Report;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.file.filters.LastModifiedFileListFilter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Конфигурация интеграционного профиля
 */
@Configuration
public class IntegrationConfig {
  @Bean(name = "ariadnaJaxb2Marshaller")
  public Jaxb2Marshaller ariadnaJaxb2Marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("mis.integration.ariadna.data");
    return marshaller;
  }

  @Bean(name = "ariadnaTransformerBean")
  public Transformer ariadnaTransformerBean() {
    return new Transformer();
  }

  @Bean(name = "misReportMarshaller")
  public Jaxb2Marshaller misReportMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(Report.class);
    return marshaller;
  }

  @Bean(name = "misPrescriptionMarshaller")
  public Jaxb2Marshaller misPrescriptionMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(PrescriptionDTO.class);
    return marshaller;
  }

  @Bean(name = "ageFileFilter")
  public LastModifiedFileListFilter ageFileFilter() {
    LastModifiedFileListFilter result = new LastModifiedFileListFilter();
    result.setAge(120);
    return result;
  }
}
