package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.services.beanregistration.LionBeanFactoryPostProcessor;
import aldora.spring.dependencyinjection.services.beanregistration.MonkeyBeanDefinitionRegistryPostProcessor;
import aldora.spring.dependencyinjection.services.beanregistration.PandaFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {
    @Bean
    public LionBeanFactoryPostProcessor lionBeanFactoryPostProcessor() {
        return new LionBeanFactoryPostProcessor();
    }

    @Bean
    public MonkeyBeanDefinitionRegistryPostProcessor monkeyBeanDefinitionRegistryPostProcessor() {
        return new MonkeyBeanDefinitionRegistryPostProcessor();
    }

    @Bean
    public PandaFactoryBean pandaFactoryBean() {
        PandaFactoryBean pandaFactoryBean = new PandaFactoryBean();
        pandaFactoryBean.setAnimalName("panda from factory");
        return pandaFactoryBean;
    }
}
