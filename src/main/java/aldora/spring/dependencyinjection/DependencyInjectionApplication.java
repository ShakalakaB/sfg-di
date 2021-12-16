package aldora.spring.dependencyinjection;

import aldora.spring.dependencyinjection.config.ApplicationConfig;
import aldora.spring.dependencyinjection.config.ApplicationConstructorConfig;
import aldora.spring.dependencyinjection.controllers.*;
import aldora.spring.dependencyinjection.controllers.PetController;
import aldora.spring.dependencyinjection.datasource.FakeDataSource;
import aldora.spring.dependencyinjection.services.PrototypeBean;
import aldora.spring.dependencyinjection.services.SingletonBean;
import aldora.spring.dependencyinjection.services.registerbean.Animal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"aldora.spring.dependencyinjection", "com.spring.pet"})
@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);

		System.out.println("\n----- BeanFactoryPostProcessor register bean: animal");
		Animal animal = applicationContext.getBean("animal", Animal.class);
		System.out.println(animal.getAnimalName());
	}
}
