package LLD.NullObjectDesignPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car("Red", 4);
        } else if(type.equalsIgnoreCase("bike")){
            return new Bike("Blue", 2);
        } else {
            return new NullVehicle();
        }
    }
}
