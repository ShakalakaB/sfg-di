package aldora.spring.dependencyinjection.controller;

import aldora.spring.dependencyinjection.services.beanregistration.Cheetah;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterBeanController {
    @GetMapping("/cheetah/{property}")
    @ResponseStatus(HttpStatus.OK)
    public String registerAnimalBean(@PathVariable String property) {
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("animalName", property);

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Cheetah.class);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);


        DefaultListableBeanFactory context = new DefaultListableBeanFactory();
        context.registerBeanDefinition("cheetah", genericBeanDefinition);

        Cheetah cheetahBean = context.getBean(Cheetah.class);
        return cheetahBean.getAnimalName();
    }
}
