package LLD.FectoryPattern.AbstractFactory.builtOnSimpleFactory;

public class CarFactoryProducer {
    public  Object getFactory(String choice){
        if(choice.equalsIgnoreCase("exterior"))
            return new ExteriorFactory();
        else if(choice.equalsIgnoreCase("interior"))
            return new InteriorFactory();
        else
            return null;
    }
}
