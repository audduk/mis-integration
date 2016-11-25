package mis.integration.ariadna.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Основная конфигурация приложения
 */
@Configuration
@EnableWebMvc
@ComponentScan("mis.integration.ariadna")
@PropertySource("classpath:application.properties")
@ImportResource(locations = {"/WEB-INF/spring/report-integration.xml", "/WEB-INF/spring/request-integration.xml"})
public class AppWebConfig extends WebMvcConfigurerAdapter {
}
