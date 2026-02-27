package LLD.FectoryPattern.Factory.SimpleFectory;

import LLD.FectoryPattern.Factory.Shape;
import LLD.FectoryPattern.Factory.ShapeType;

public class SimpleFactoryDemo {
    public static void main(String args[]){
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE);
        circle.computeArea();
        circle.draw();
        System.out.println("-----------------------------");

        Shape square = ShapeFactory.createShape(ShapeType.SQUARE);
        square.computeArea();
        square.draw();
        System.out.println("-----------------------------");

        Shape rect = ShapeFactory.createShape(ShapeType.RECTANGLE);
        rect.computeArea();
        rect.draw();
        System.out.println("-----------------------------");
    }
}
