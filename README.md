# Dependency Injection Examples

This repository start from an example application built in [Spring Framework 5 - Beginner to Guru](https://www.udemy.com/testing-spring-boot-beginner-to-guru/?couponCode=GITHUB_REPO) online course

## Notes
+ main three ways of dependency injection: constructor, property, setter.
+ Instead of manually initialize injected objects, spring would automatically inject beans(IoC: Inversion of Control) if we properly annotation class.
  - `@Service`, `@Component`, `@Repository`
  - `@Configuration`
+ How to solve injection conflicts of multiple implementation of an interface: `@Qualifier`,**`@Profile`**.
+ Use file: `application.properties`, `application.yml`, `datasource.properties` to bind data