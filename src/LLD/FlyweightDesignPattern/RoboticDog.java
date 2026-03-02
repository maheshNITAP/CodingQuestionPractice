package LLD.FlyweightDesignPattern;

public class RoboticDog implements IRobot {
    private String type;
    private Sprites body;

    public RoboticDog(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        //use the Robotic Dog sprites object
        // and X and Y coordinate to render the image.

        System.out.println("Displaying " + type + " robotic dog at coordinates (" + x + ", " + y + ")");
    }
}
