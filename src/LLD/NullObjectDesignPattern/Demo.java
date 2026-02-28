package LLD.NullObjectDesignPattern;

public class Demo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("car");
        car.start();
        car.stop();

        System.out.println("--------do nothing when type is unknown-----------");
        Vehicle truck = VehicleFactory.getVehicle("truck");
        truck.start();
        truck.stop();
        System.out.println("--------did nothing when type is unknown-----------");

        Vehicle bike = VehicleFactory.getVehicle("bike");
        bike.start();
        bike.stop();


    }
}
