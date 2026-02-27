package LLD.FectoryPattern.Factory.FectoryMethod;

import LLD.FectoryPattern.Factory.Shape;
import LLD.FectoryPattern.Factory.ShapeType;

public class FactoryMethodDemo {
    public static void main(String args[]){
        Shape circle = ShapeFactoryMethod.getShapeInstance(ShapeType.CIRCLE);
        circle.computeArea();
        circle.draw();
        System.out.println("-----------------------------");

        Shape square = ShapeFactoryMethod.getShapeInstance(ShapeType.SQUARE);
        square.computeArea();
        square.draw();
        System.out.println("-----------------------------");
    }
}
