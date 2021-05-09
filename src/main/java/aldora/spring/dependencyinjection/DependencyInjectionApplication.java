package aldora.spring.dependencyinjection;

import aldora.spring.dependencyinjection.controllers.*;
import aldora.spring.dependencyinjection.controllers.PetController;
import aldora.spring.dependencyinjection.datasource.FakeDataSource;
import aldora.spring.dependencyinjection.services.PrototypeBean;
import aldora.spring.dependencyinjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"aldora.spring.dependencyinjection", "com.spring.pet"})
@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DependencyInjectionApplication.class, args);

		System.out.println("\n----- which pet is best");
		PetController petController = applicationContext.getBean("petController", PetController.class);
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("\n----- primary bean");
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

		System.out.println("\n----- profile");
		I18nController i18nController = (I18nController) applicationContext.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("\n----- bean scope");
		SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getScope());
		SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getScope());

		PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());
		PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());


		System.out.println("\n----- fake datasource");
		FakeDataSource fakeDataSource = applicationContext.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());
	}

}
