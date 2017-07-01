package app.config;

import app.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:wsiz-config/our-config.xml")
public class SmallConfig {

    //Tworzenie serwisu dla przypadku aplikacji nie-webowych
    //(czyli np. z SimpleJpaQueriesStart)
    @Bean
    OrderService orderService() {
        return new OrderService();
    }
}
