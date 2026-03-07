package LLD.visitorDesignPattern.visitor;

import LLD.visitorDesignPattern.element.DeluxeRoom;
import LLD.visitorDesignPattern.element.DoubleRoom;
import LLD.visitorDesignPattern.element.SingleRoom;

public class RoomMaintenanceVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Performing maintenance for Single Room");
        // Perform maintenance tasks specific to Single Room
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Performing maintenance for Double Room");
        // Perform maintenance tasks specific to Double Room
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Performing maintenance for Deluxe Room");
        // Perform maintenance tasks specific to Deluxe Room
    }
}
