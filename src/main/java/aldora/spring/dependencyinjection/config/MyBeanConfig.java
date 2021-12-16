package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.services.beanregistration.LionBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {
    @Bean
    public LionBeanFactoryPostProcessor lionBeanFactoryPostProcessor() {
        return new LionBeanFactoryPostProcessor();
    }
}
