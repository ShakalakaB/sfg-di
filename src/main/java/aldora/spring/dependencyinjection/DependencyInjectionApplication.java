package aldora.spring.dependencyinjection;

import aldora.spring.dependencyinjection.controllers.MyController;
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
	}

}
