package LLD.FectoryPattern.Factory.FectoryMethod;

import LLD.FectoryPattern.Factory.Rectangle;
import LLD.FectoryPattern.Factory.Shape;

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
