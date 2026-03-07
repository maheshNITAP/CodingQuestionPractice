package LLD.visitorDesignPattern.element;

import LLD.visitorDesignPattern.visitor.RoomVisitor;

public class DeluxeRoom implements RoomElement{
    public int roomPrice=0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }

}
