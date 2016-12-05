package mis.integration.ariadna.config;

import mis.integration.ariadna.Md5Transformer;
import mis.integration.ariadna.ReportTransformer;
import mis.integration.ariadna.RequestFileNameGenerator;
import mis.integration.ariadna.PrescriptionTransformer;
import mis.integration.ariadna.file.PdfSplitter;
import mis.integration.ariadna.file.ZipTransformer;
import mis.lis.prescription.PrescriptionDTO;
import mis.lis.report.Report;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.file.FileNameGenerator;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.FileListFilter;
import org.springframework.integration.file.filters.LastModifiedFileListFilter;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.File;
import java.util.regex.Pattern;

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

  @Bean(name = "prescriptionTransformer")
  public PrescriptionTransformer prescriptionTransformer() {
    return new PrescriptionTransformer();
  }

  @Bean(name = "reportTransformer")
  public ReportTransformer reportTransformer() {
    return new ReportTransformer();
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

  @Bean(name = "xmlFileFilter")
  public FileListFilter xmlFileFilter() {
    return getFileListFilter("xml");
  }

  @Bean(name = "md5FileFilter")
  public FileListFilter md5FileFilter() {
    return getFileListFilter("md5");
  }

  private FileListFilter getFileListFilter(String ext) {
    CompositeFileListFilter<File> result = new CompositeFileListFilter<>();
    LastModifiedFileListFilter ageFilter = new LastModifiedFileListFilter();
    ageFilter.setAge(120);
    result.addFilter(ageFilter);
    result.addFilter(new RegexPatternFileListFilter(Pattern.compile(".*\\." + ext, Pattern.CASE_INSENSITIVE)));
    return result;
  }

  @Bean(name = "md5Transformer")
  public Md5Transformer md5Transformer() {
    return new Md5Transformer();
  }

  @Bean(name = "xmlReportFileGenerator")
  FileNameGenerator xmlReportFileGenerator() {
    return new RequestFileNameGenerator("xml");
  }

  @Bean(name = "md5ReportFileGenerator")
  FileNameGenerator md5ReportFileGenerator() {
    return  new RequestFileNameGenerator("md5");
  }

  @Bean(name = "zipTransformer")
  public ZipTransformer zipTransformer() {
    return new ZipTransformer();
  }

  @Bean(name = "pdfSplitter")
  public PdfSplitter pdfSplitter() {
    return new PdfSplitter();
  }
}
