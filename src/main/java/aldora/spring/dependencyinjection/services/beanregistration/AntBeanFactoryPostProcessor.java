package aldora.spring.dependencyinjection.services.beanregistration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AntBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("---- inside AntBeanFactoryPostProcessor");
        // remove original bean definition
        ((DefaultListableBeanFactory) configurableListableBeanFactory).removeBeanDefinition("ant");

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Ant.class);
        genericBeanDefinition.getPropertyValues().add("animalName", "ant from BeanFactoryPostProcessor");

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
                .registerBeanDefinition("ant", genericBeanDefinition);
    }
}
