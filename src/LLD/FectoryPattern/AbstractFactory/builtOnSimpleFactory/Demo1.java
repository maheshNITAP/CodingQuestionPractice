package LLD.FectoryPattern.AbstractFactory.builtOnSimpleFactory;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.CarInterior;

public class Demo1 {
    public static void main(String[] args){
        InteriorFactory interiorFactory = (InteriorFactory) CarFactoryProducer.getFactory("interior");

        CarInterior interior = InteriorFactory.getInterior("economy");
        interior.addComponents();
        System.out.println("-----------------------------");


        ExteriorFactory exteriorFactory = (ExteriorFactory) CarFactoryProducer.getFactory("exterior");

        CarExterior exterior = ExteriorFactory.getExterior("luxury");
        exterior.addComponents();


    }
}
