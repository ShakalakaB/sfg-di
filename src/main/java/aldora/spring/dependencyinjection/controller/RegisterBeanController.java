package aldora.spring.dependencyinjection.controller;

import aldora.spring.dependencyinjection.services.beanregistration.Animal;
import aldora.spring.dependencyinjection.services.beanregistration.Cheetah;
import aldora.spring.dependencyinjection.services.beanregistration.Turtle;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterBeanController {
    private static final String BEAN_NAME = "cheetah";
    private final BeanFactory beanFactory;
    private final ApplicationContext applicationContext;

    public RegisterBeanController(BeanFactory beanFactory, ApplicationContext applicationContext) {
        this.beanFactory = beanFactory;
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

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("cheetah", genericBeanDefinition);
        Cheetah cheetahBean = beanFactory.getBean(Cheetah.class);

        return cheetahBean.getAnimalName();
    }

    @GetMapping("/turtle/{property}")
    @ResponseStatus(HttpStatus.OK)
    public String registerViaBeanDefinitionBuilder(@PathVariable String property) {
        if (beanFactory.containsBean(BEAN_NAME)) {
            return "sorry, turtle bean already registered";
        }

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("animalName", property);

       BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Turtle.class)
               .addPropertyValue("animalName", property);

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
}
