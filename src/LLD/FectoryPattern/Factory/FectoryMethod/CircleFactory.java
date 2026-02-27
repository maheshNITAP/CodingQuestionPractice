package LLD.FectoryPattern.Factory.FectoryMethod;

import LLD.FectoryPattern.Factory.Circle;
import LLD.FectoryPattern.Factory.Shape;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
