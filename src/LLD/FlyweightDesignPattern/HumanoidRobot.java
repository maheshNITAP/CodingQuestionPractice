package LLD.FlyweightDesignPattern;

public class HumanoidRobot implements IRobot{

    private String type;
    private Sprites body;

    public HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        // use the humanoid sprites object
        // and X and Y coordinate to render the image.
        System.out.println("Displaying " + type + " at " + x + ", " + y);

    }
}
