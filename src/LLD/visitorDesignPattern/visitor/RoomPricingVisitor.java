package LLD.visitorDesignPattern.visitor;

import LLD.visitorDesignPattern.element.DeluxeRoom;
import LLD.visitorDesignPattern.element.DoubleRoom;
import LLD.visitorDesignPattern.element.SingleRoom;

public class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Calculating price for Single Room");
        singleRoom.roomPrice = 100;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Calculating price for Double Room");
        doubleRoom.roomPrice = 150;
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Calculating price for Deluxe Room");
        deluxeRoom.roomPrice = 200;
    }
}
