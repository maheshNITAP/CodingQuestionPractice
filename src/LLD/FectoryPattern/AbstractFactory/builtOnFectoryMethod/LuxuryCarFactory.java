package LLD.FectoryPattern.AbstractFactory.builtOnFectoryMethod;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.CarInterior;
import LLD.FectoryPattern.AbstractFactory.LuxuryExterior;
import LLD.FectoryPattern.AbstractFactory.LuxuryInterior;

public class LuxuryCarFactory implements CarFactory {

    @Override
    public CarInterior createInterior() {
        return new LuxuryInterior();
    }

    @Override
    public CarExterior createExterior() {
        return new LuxuryExterior();
    }
}
