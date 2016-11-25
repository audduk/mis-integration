package mis.integration.ariadna.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Вместо Web xml
 */
public class WebAppInitializer implements WebApplicationInitializer {

  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(AppWebConfig.class);
    ctx.setServletContext(servletContext);

    ServletRegistration.Dynamic dynamic = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
    dynamic.addMapping("/");
    dynamic.setLoadOnStartup(1);
    dynamic.setAsyncSupported(true);
  }
}
