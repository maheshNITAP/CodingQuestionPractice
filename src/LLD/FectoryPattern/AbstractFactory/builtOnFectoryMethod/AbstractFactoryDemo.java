package LLD.FectoryPattern.AbstractFactory.builtOnFectoryMethod;


public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CarFactoryProvider carFactoryProvider = new CarFactoryProvider();
        CarFactory economyCar = carFactoryProvider.getFactory("economy");
        assert economyCar != null;
        economyCar.produceCompleteVehicle();
        System.out.println("-----------------------------");

        CarFactory luxuryCar = carFactoryProvider.getFactory("luxury");
        luxuryCar.produceCompleteVehicle();


    }
}
