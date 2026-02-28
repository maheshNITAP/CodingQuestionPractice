package LLD.NullObjectDesignPattern;

public class Bike implements Vehicle {
    private String color;
    private int seatingCapacity;

    public Bike(String color, int seatingCapacity) {
        this.color = color;
        this.seatingCapacity = seatingCapacity;
    }
    @Override
    public void start() {
        System.out.println("Bike started.");
    }
    @Override
    public void stop() {
        System.out.println("Bike stopped.");
    }
    public String getColor() {
        return color;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
