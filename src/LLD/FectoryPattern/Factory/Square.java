package LLD.FectoryPattern.Factory;

public class Square implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Computing area of Square");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}
