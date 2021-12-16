package aldora.spring.dependencyinjection.controller;

import aldora.spring.dependencyinjection.services.beanregistration.Animal;
import aldora.spring.dependencyinjection.services.beanregistration.Cheetah;
import aldora.spring.dependencyinjection.services.beanregistration.Panda;
import aldora.spring.dependencyinjection.services.beanregistration.Turtle;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterBeanController {
    private static final String BEAN_NAME = "cheetah";
    private final BeanFactory beanFactory;
    private final Panda panda;
    private final ApplicationContext applicationContext;

    public RegisterBeanController(BeanFactory beanFactory, Panda panda, ApplicationContext applicationContext) {
        this.beanFactory = beanFactory;
        this.panda = panda;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/cheetah/{property}")
    @ResponseStatus(HttpStatus.OK)
    public String registerViaGenericBeanDefinition(@PathVariable String property) {
        if (beanFactory.containsBean(BEAN_NAME)) {
            return "sorry, cheetah bean already registered";
        }

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("animalName", property);

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Cheetah.class);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        genericBeanDefinition.setLazyInit(true);

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("cheetah", genericBeanDefinition);

        boolean exist1 = ((DefaultListableBeanFactory) beanFactory).getSingleton("cheetah") != null;
        System.out.println("Lazy init bean, before beanFactory.getBean method, exist or not: " + exist1);

        Cheetah cheetahBean = beanFactory.getBean(Cheetah.class);

        boolean exist2 = ((DefaultListableBeanFactory) beanFactory).getSingleton("cheetah") != null;
        System.out.println("Lazy init bean, after beanFactory.getBean method, exist or not: " + exist2);

        return cheetahBean.getAnimalName();
    }

    @GetMapping("/turtle/{property}")
    @ResponseStatus(HttpStatus.OK)
    public String registerViaBeanDefinitionBuilder(@PathVariable String property) {
        if (beanFactory.containsBean("turtle")) {
            return "sorry, turtle bean already registered";
        }

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("animalName", property);

       BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Turtle.class)
               .addPropertyValue("animalName", property)
               .setLazyInit(true);

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("turtle", beanDefinitionBuilder.getBeanDefinition());
        Turtle turtleBean = beanFactory.getBean(Turtle.class);

        return turtleBean.getAnimalName();
    }

    @GetMapping("/check/bean/{beanName}")
    public String checkBean(@PathVariable String beanName) {
        if (beanFactory.containsBean(beanName)) {
            return ((Animal) beanFactory.getBean(beanName)).getAnimalName();
        }
        return "bean unbound";
    }

    @GetMapping("/remove/bean/{beanName}")
    public String removeBean(@PathVariable String beanName) {
        if (beanFactory.containsBean(beanName)) {
            ((BeanDefinitionRegistry) beanFactory).removeBeanDefinition(beanName);
            return beanName + " removed.";
        }
        return "bean unbound";
    }
}
