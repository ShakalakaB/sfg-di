package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.services.beanregistration.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {
    @Bean
    public LionBeanFactoryPostProcessor lionBeanFactoryPostProcessor() {
        return new LionBeanFactoryPostProcessor();
    }

    @Bean
    public AntBeanDefinitionRegistryPostProcessor lionBeanDefinitionRegistryPostProcessor() {
        return new AntBeanDefinitionRegistryPostProcessor();
    }

    @Bean
    public AntBeanFactoryPostProcessor antBeanFactoryPostProcessor() {
        return new AntBeanFactoryPostProcessor();
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
