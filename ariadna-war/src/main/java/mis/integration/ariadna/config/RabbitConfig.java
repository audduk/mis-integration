package mis.integration.ariadna.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
  @Value("${rabbitmq.host:localhost}")
  private String host;
  @Value("${rabbitmq.username:mis}")
  private String username;
  @Value("${rabbitmq.password:123123}")
  private String password;
  @Value("${rabbitmq.vhost:misvhost}")
  private String vhost;

  @Bean(name = "connectionFactory")
  public CachingConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    connectionFactory.setVirtualHost(vhost);
    return connectionFactory;
  }

  @Bean(name = "rabbitTemplate")
  public RabbitTemplate rabbitTemplate() {
    return new RabbitTemplate(connectionFactory());
  }
}
