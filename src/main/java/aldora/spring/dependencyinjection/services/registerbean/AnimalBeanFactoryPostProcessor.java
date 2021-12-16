package aldora.spring.dependencyinjection.services.registerbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class AnimalBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Animal.class);
        genericBeanDefinition.getPropertyValues().add("animalName", "lion");

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
                .registerBeanDefinition("animal", genericBeanDefinition);
    }
}
