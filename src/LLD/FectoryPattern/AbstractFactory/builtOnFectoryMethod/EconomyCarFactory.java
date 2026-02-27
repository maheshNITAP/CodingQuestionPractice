package LLD.FectoryPattern.AbstractFactory.builtOnFectoryMethod;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.CarInterior;
import LLD.FectoryPattern.AbstractFactory.EconomyExterior;
import LLD.FectoryPattern.AbstractFactory.EconomyInterior;


public class EconomyCarFactory implements CarFactory {

    @Override
    public CarInterior createInterior() {
        return new EconomyInterior();
    }

    @Override
    public CarExterior createExterior() {
        return new EconomyExterior();
    }
}
