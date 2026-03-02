package LLD.FlyweightDesignPattern;

public class Client {
    public static void main(String[] args) {
        IRobot humanRobot1=RoboticFactory.createRobot("HUMANOID");
        humanRobot1.display(10, 20);

        IRobot humanRobot2=RoboticFactory.createRobot("HUMANOID");
        humanRobot2.display(30, 40);

        IRobot roboticDog1=RoboticFactory.createRobot("ROBOTIC_DOG");
        roboticDog1.display(50, 60);

        IRobot roboticDog2=RoboticFactory.createRobot("ROBOTIC_DOG");
        roboticDog2.display(70, 80);


    }
}
