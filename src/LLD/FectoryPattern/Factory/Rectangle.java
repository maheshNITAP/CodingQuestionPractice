package LLD.FectoryPattern.Factory;

public class Rectangle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Computing area of Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
