package aldora.spring.dependencyinjection.services.beanregistration;

public class Monkey implements Animal{
    private String animalName;

    @Override
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String getAnimalName() {
        return animalName;
    }
}
