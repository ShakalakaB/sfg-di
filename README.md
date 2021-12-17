# Dependency Injection Examples

This repository start from an example application built in [Spring Framework 5 - Beginner to Guru](https://www.udemy.com/testing-spring-boot-beginner-to-guru/?couponCode=GITHUB_REPO) online course

## Notes
#### Dependency Injection(master branch)
+ main three ways of dependency injection: constructor, property, setter.
+ Instead of manually initialize injected objects, spring would automatically inject beans(IoC: Inversion of Control) if we properly annotation class.
  - `@Service`, `@Component`, `@Repository`
  - `@Configuration`
+ How to solve injection conflicts of multiple implementation of an interface: `@Qualifier`,**`@Profile`**.
+ Use file: `application.properties`, `application.yml`, `datasource.properties` to bind data

#### Bean Registration(dynamic-bean-registration branch)
+ [main ways to create bean](https://codippa.com/how-to-create-bean-in-spring/)
+ [factory bean](https://www.baeldung.com/spring-factorybean)
+ [dynamically autowire a bean](https://www.baeldung.com/spring-dynamic-autowire)
+ [four ways to dynamically register a bean](https://www.javaprogramto.com/2019/07/spring-dynamically-register-beans.html)
  - GenericBeanDefinition
  - BeanDefinitionBuilder
  - BeanFactoryPostProcessor
  - BeanDefinitionRegistryPostProcessor
  
+ [use ImportBeanDefinitionRegistrar to register a bean](https://www.cnblogs.com/binghe001/p/13150084.html)
+ `BeanFactoryPostProcessor` `BeanDefinitionRegistryPostProcessor` both can be used to change bean definition, but `BeanFactoryPostProcessor` is better because:
> A BeanFactoryPostProcessor may interact with and modify bean definitions, but never bean instances. Allows for custom modification of an application context's bean definitions, adapting the bean property values of the context's underlying bean factory. Application contexts can auto-detect BeanFactoryPostProcessor beans in their bean definitions and apply them before any other beans get created.
