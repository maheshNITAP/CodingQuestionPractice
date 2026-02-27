package LLD.FectoryPattern.AbstractFactory.builtOnFectoryMethod;

public class CarFactoryProvider {
    public  CarFactory getFactory(String carType){
        switch (carType){
            case "economy":
                return new EconomyCarFactory();
            case "luxury":
                return new LuxuryCarFactory();
            default:
                return null;
        }
    }
}
