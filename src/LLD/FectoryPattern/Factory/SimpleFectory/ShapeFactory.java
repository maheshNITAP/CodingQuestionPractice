package LLD.FectoryPattern.Factory.SimpleFectory;

import LLD.FectoryPattern.Factory.*;

public class ShapeFactory {
    public static Shape createShape(ShapeType shapeType){
        if(shapeType.equals(ShapeType.CIRCLE))
            return new Circle();
        else if(shapeType.equals(ShapeType.SQUARE))
            return new Square();
        else if(shapeType.equals(ShapeType.RECTANGLE))
            return new Rectangle();
        return null;
    }
}
