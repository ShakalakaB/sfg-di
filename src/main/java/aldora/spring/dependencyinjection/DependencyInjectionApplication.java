package aldora.spring.dependencyinjection;

import aldora.spring.dependencyinjection.services.beanregistration.Lion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"aldora.spring.dependencyinjection", "com.spring.pet"})
@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);

		System.out.println("\n----- BeanFactoryPostProcessor register bean: animal");
		Lion lion = applicationContext.getBean("animal", Lion.class);
		System.out.println(lion.getAnimalName());
	}
}
