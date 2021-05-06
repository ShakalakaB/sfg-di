package aldora.spring.dependencyinjection.controllers;

import aldora.spring.dependencyinjection.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new ConstructorGreetingService();
    }

    @Test
    void sayHello() {
        System.out.println(propertyInjectedController.sayHello());
    }
}