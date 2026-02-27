package LLD.FectoryPattern.AbstractFactory.builtOnFectoryMethod;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.CarInterior;

public interface CarFactory {
    CarInterior createInterior();
    CarExterior createExterior();

    default void produceCompleteVehicle() {
        CarInterior interior = createInterior();
        CarExterior exterior = createExterior();

        interior.addComponents();
        exterior.addComponents();

        System.out.println("Car production completed.");
    }
}
