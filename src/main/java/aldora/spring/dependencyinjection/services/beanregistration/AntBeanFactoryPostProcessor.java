package aldora.spring.dependencyinjection.services.beanregistration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class AntBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // remove original bean definition
        ((DefaultListableBeanFactory) configurableListableBeanFactory).removeBeanDefinition("ant");

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Lion.class);
        genericBeanDefinition.getPropertyValues().add("animalName", "ant from BeanFactoryPostProcessor");

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
                .registerBeanDefinition("ant", genericBeanDefinition);
    }
}
