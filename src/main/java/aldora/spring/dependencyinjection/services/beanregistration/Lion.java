package aldora.spring.dependencyinjection.services.beanregistration;

public class Lion implements Animal {
    private String animalName;

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }
}