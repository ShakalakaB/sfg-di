package aldora.spring.dependencyinjection.services.beanregistration;

import org.springframework.stereotype.Service;

@Service
public class Ant implements Animal{
    private String animalName;

    public Ant() {
        this.animalName = "ant from original registration";
    }

    @Override
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String getAnimalName() {
        return animalName;
    }
}
