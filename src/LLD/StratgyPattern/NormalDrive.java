package LLD.StratgyPattern;

public class NormalDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Driving in normal mode");
    }
}
