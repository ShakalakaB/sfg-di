package aldora.spring.dependencyinjection.services.beanregistration;

public class Panda implements Animal{
    private String animalName;

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }
}
