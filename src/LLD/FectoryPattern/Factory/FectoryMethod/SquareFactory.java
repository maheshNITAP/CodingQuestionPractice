package LLD.FectoryPattern.Factory.FectoryMethod;

import LLD.FectoryPattern.Factory.Shape;
import LLD.FectoryPattern.Factory.Square;

public class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
