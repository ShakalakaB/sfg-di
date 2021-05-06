package aldora.spring.dependencyinjection;

import aldora.spring.dependencyinjection.controllers.ConstructorInjectedController;
import aldora.spring.dependencyinjection.controllers.MyController;
import aldora.spring.dependencyinjection.controllers.PropertyInjectedController;
import aldora.spring.dependencyinjection.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);

		MyController myController = (MyController) applicationContext.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("\n----- property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.sayHello());

		System.out.println("\n----- setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) applicationContext.getBean("setterInjectedController");
		System.out.println(setterInjectedController.sayHello());

		System.out.println("\n----- constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.sayHello());
	}

}