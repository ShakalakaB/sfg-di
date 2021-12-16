package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.services.registerbean.AnimalBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {
    @Bean
    public AnimalBeanFactoryPostProcessor animalBeanFactoryPostProcessor() {
        return new AnimalBeanFactoryPostProcessor();
    }
}
