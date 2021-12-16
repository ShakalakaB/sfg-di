package aldora.spring.dependencyinjection.controller;

import aldora.spring.dependencyinjection.services.beanregistration.Cheetah;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterBeanController {
    private static final String BEAN_NAME = "cheetah";
    private final BeanFactory beanFactory;

    public RegisterBeanController(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @GetMapping("/cheetah/{property}")
    @ResponseStatus(HttpStatus.OK)
    public String registerAnimalBean(@PathVariable String property) {
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("animalName", property);

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Cheetah.class);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        if (beanFactory.containsBean(BEAN_NAME)) {
            return "sorry, cheetah bean already registered";
        }
        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("cheetah", genericBeanDefinition);
        Cheetah cheetahBean = beanFactory.getBean(Cheetah.class);

        return cheetahBean.getAnimalName();
    }

    @GetMapping("/check/bean")
    public String checkBean() {
        if (beanFactory.containsBean(BEAN_NAME)) {
            return beanFactory.getBean(Cheetah.class).getAnimalName();
        }
        return "bean unbound";
    }
}
