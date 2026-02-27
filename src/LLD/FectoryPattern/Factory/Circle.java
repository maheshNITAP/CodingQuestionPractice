package LLD.FectoryPattern.Factory;

public class Circle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Computing area of Circle");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
