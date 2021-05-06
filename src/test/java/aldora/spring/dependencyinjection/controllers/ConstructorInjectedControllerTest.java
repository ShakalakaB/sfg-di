package aldora.spring.dependencyinjection.controllers;

import aldora.spring.dependencyinjection.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp() {
        this.constructorInjectedController = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void sayHello() {
        System.out.println(constructorInjectedController.sayHello());
    }

}