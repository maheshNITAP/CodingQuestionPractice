package LLD.NullObjectDesignPattern;

public class Car implements Vehicle {
    private String color;
    private int seatingCapacity;

    public Car(String color, int seatingCapacity) {
        this.color = color;
        this.seatingCapacity = seatingCapacity;
    }
    @Override
    public void start() {
        System.out.println("Car started.");
    }
    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
    public String getColor() {
        return color;
    }
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
