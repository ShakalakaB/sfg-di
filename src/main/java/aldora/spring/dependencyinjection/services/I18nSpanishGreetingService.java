package aldora.spring.dependencyinjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("ES")
//@Service("i18Service")
public class I18nSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - ES";
    }
}
