package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.services.ConstructorGreetingService;
import aldora.spring.dependencyinjection.services.PropertyGreetingService;
import aldora.spring.dependencyinjection.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

}
