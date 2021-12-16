package aldora.spring.dependencyinjection.services.beanregistration;

import org.springframework.beans.factory.FactoryBean;

public class PandaFactoryBean implements FactoryBean<Panda> {
    private String animalName;

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public Panda getObject() throws Exception {
        Panda panda = new Panda();
        panda.setAnimalName(animalName);
        return panda;
    }

    @Override
    public Class<?> getObjectType() {
        return Panda.class;
    }
}
