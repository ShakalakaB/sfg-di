package aldora.spring.dependencyinjection.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements
        InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## 1. I'm in the LifeCycleBean Constructor");
    }

    /**
     * {@link BeanNameAware}
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("## 2. My Bean Name is: " + name);
    }

    /**
     * {@link BeanFactoryAware}
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## 3. Bean Factory has been set");
    }

    /**
     * {@link ApplicationContextAware}
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## 4. Application context has been set");
    }

    /**
     * {@link LifeCycleDemoBeanPostProcessor}
     */
    public void beforeInit() {
        System.out.println("## 5. Before Init called by BeanPostProcessor: LifeCycleDemoBeanPostProcessor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## 6. The Post Construct annotated method has been called");
    }

    /**
     * {@link InitializingBean}
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## 7. The LifeCycleBean has its properties set!");
    }

    /**
     * {@link LifeCycleDemoBeanPostProcessor}
     */
    public void afterInit() {
        System.out.println("## 8. After init called by Bean Post Processor");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## 9. The PreDestroy annotated method has been called");
    }

    /**
     * {@link DisposableBean}
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("## 10. The Lifecycle bean has been terminated");
    }
}
