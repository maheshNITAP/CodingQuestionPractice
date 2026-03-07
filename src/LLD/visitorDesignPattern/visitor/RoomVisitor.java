package LLD.visitorDesignPattern.visitor;

import LLD.visitorDesignPattern.element.DeluxeRoom;
import LLD.visitorDesignPattern.element.DoubleRoom;
import LLD.visitorDesignPattern.element.SingleRoom;

public interface RoomVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);

    void visit(DeluxeRoom deluxeRoom);
}
