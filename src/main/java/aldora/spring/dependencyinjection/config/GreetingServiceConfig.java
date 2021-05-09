package aldora.spring.dependencyinjection.config;

import aldora.spring.dependencyinjection.datasource.FakeDataSource;
import aldora.spring.dependencyinjection.repositories.EnglishGreetingRepository;
import aldora.spring.dependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import aldora.spring.dependencyinjection.services.*;
import com.spring.pet.PetService;
import com.spring.pet.PetServiceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(ApplicationConstuctorConfig.class)
@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:dependency-injection.xml")
@Configuration
public class GreetingServiceConfig {

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    @Profile({"EN", "default"})
    I18nEnglishGreetingService i18Service(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean("i18Service")
//    @Profile({"ES", "default"})
    @Profile("ES")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

//    @Bean
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

//    @Bean
//    FakeDataSource fakeDataSource(@Value("${db.username}") String username,
//                                  @Value("${db.password}") String password,
//                                  @Value("${db.jdbcurl}") String url) {
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcurl(url);
//
//        return fakeDataSource;
//    }

    @Bean
    FakeDataSource fakeDataSource(ApplicationConstuctorConfig applicationConstuctorConfig) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(applicationConstuctorConfig.getUsername());
        fakeDataSource.setPassword(applicationConstuctorConfig.getPassword());
        fakeDataSource.setJdbcurl(applicationConstuctorConfig.getJdbcurl());

        return fakeDataSource;
    }
}
