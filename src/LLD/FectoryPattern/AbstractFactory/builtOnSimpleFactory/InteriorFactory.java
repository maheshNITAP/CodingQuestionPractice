package LLD.FectoryPattern.AbstractFactory.builtOnSimpleFactory;

import LLD.FectoryPattern.AbstractFactory.CarInterior;
import LLD.FectoryPattern.AbstractFactory.EconomyInterior;
import LLD.FectoryPattern.AbstractFactory.LuxuryInterior;

public class InteriorFactory {
    public static CarInterior getInterior(String type){
        if(type.equalsIgnoreCase("economy"))
            return new EconomyInterior();
        else if(type.equalsIgnoreCase("luxury"))
            return new LuxuryInterior();
        else
            return null;
    }
}
