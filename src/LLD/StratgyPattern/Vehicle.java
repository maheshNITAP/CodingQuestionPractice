package LLD.StratgyPattern;

public class Vehicle {
    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        System.out.println(this.getClass().getSimpleName()+" is driving");
        driveStrategy.drive();
        System.out.println("\n");
    }
}
