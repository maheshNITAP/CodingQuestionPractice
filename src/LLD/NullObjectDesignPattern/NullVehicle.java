package LLD.NullObjectDesignPattern;

public class NullVehicle implements Vehicle {
    private String color="default";
    private int seatingCapacity=0;

    public NullVehicle() {
        // Default constructor
    }


    @Override
    public void start() {
        // Do nothing
    }
    @Override
    public void stop() {
        // Do nothing
    }
    public String getColor() {
        return color;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
