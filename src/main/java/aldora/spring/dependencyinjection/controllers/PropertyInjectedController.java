package aldora.spring.dependencyinjection.controllers;

import aldora.spring.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
