package aldora.spring.dependencyinjection.controllers;

import aldora.spring.dependencyinjection.services.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
