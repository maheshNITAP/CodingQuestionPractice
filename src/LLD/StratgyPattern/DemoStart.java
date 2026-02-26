package LLD.StratgyPattern;

public class DemoStart {
    public static void main(String[] args) {

        //Strategy pattern is used to change the behaviour of the class at runtime. It is used to define a family of algorithms, encapsulate each one, and make them interchangeable.
        // Strategy pattern lets the algorithm vary independently from clients that use it.
        Vehicle vehicle = new SportsVehicle(new SportsDrive());
        vehicle.drive();

        Vehicle vehicle1 = new GoodseVehicle(new NormalDrive());
        vehicle1.drive();

    }
}
