package LLD.FectoryPattern.Factory.FectoryMethod;

import LLD.FectoryPattern.Factory.Shape;
import LLD.FectoryPattern.Factory.ShapeType;

public class ShapeFactoryMethod {
    public static Shape getShapeInstance(ShapeType shapeType){
        Shape shape = null;
        if(shapeType.equals(ShapeType.CIRCLE)){
            ShapeFactory circleFactory = new CircleFactory();
            shape = circleFactory.createShape();
        } else if (shapeType.equals(ShapeType.SQUARE)) {
            ShapeFactory squareFactory = new SquareFactory();
            shape = squareFactory.createShape();
        } else {
            System.out.println("no shape found");
        }
        return shape;

    }
}
