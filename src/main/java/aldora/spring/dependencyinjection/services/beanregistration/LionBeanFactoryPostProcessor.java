package aldora.spring.dependencyinjection.services.beanregistration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * <p>
 *     A BeanFactoryPostProcessor may interact with and modify bean definitions,
 * but never bean instances. Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 * Application contexts can auto-detect BeanFactoryPostProcessor beans in their bean definitions
 * and apply them before any other beans get created.
 * </p>
 */
public class LionBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Lion.class);
        genericBeanDefinition.getPropertyValues().add("animalName", "lion");

        ((DefaultListableBeanFactory) configurableListableBeanFactory)
                .registerBeanDefinition("lion", genericBeanDefinition);
    }
}
