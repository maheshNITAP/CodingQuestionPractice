package LLD.FectoryPattern.AbstractFactory.builtOnSimpleFactory;

import LLD.FectoryPattern.AbstractFactory.CarExterior;
import LLD.FectoryPattern.AbstractFactory.EconomyExterior;
import LLD.FectoryPattern.AbstractFactory.LuxuryExterior;

public class ExteriorFactory {
    public static CarExterior getExterior(String type){
        if(type.equalsIgnoreCase("economy"))
            return new EconomyExterior();
        else if(type.equalsIgnoreCase("luxury"))
            return new LuxuryExterior();
        else
            return null;
    }
}
