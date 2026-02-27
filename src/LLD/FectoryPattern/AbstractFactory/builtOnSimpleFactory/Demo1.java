package LLD.FectoryPattern.AbstractFactory.builtOnSimpleFactory;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.CarInterior;

public class Demo1 {
    public static void main(String[] args){
        CarFactoryProducer carFactoryProducer = new CarFactoryProducer();
        InteriorFactory interiorFactory = (InteriorFactory) carFactoryProducer.getFactory("interior");

        CarInterior interior = InteriorFactory.getInterior("economy");
        interior.addComponents();
        System.out.println("-----------------------------");


        ExteriorFactory exteriorFactory = (ExteriorFactory) carFactoryProducer.getFactory("exterior");

        CarExterior exterior = ExteriorFactory.getExterior("luxury");
        exterior.addComponents();


    }
}
