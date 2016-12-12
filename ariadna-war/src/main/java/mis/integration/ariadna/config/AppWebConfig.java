package mis.integration.ariadna.config;

import org.springframework.context.annotation.*;

/**
 * Основная конфигурация приложения
 */
@Configuration
@ComponentScan("mis.integration.ariadna")
@PropertySource("classpath:application.properties")
@ImportResource(locations = {
    "/WEB-INF/spring/report-integration.xml",
    "/WEB-INF/spring/request-integration.xml",
    "/WEB-INF/spring/voc-integration.xml",
    "/WEB-INF/spring/services-integration.xml"})
public class AppWebConfig {
}
