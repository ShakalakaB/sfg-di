package aldora.spring.dependencyinjection.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Creating a singleton bean!");
    }

    public String getScope() {
        return "I'm a Singleton";
    }
}
