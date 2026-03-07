package LLD.visitorDesignPattern;

import LLD.visitorDesignPattern.element.DeluxeRoom;
import LLD.visitorDesignPattern.element.DoubleRoom;
import LLD.visitorDesignPattern.element.RoomElement;
import LLD.visitorDesignPattern.element.SingleRoom;
import LLD.visitorDesignPattern.visitor.RoomMaintenanceVisitor;
import LLD.visitorDesignPattern.visitor.RoomPricingVisitor;
import LLD.visitorDesignPattern.visitor.RoomVisitor;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor pricingVisitor = new RoomPricingVisitor();
        singleRoom.accept(pricingVisitor);
        System.out.println("Single Room Price: " + ((SingleRoom) singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitor);
        System.out.println("Double Room Price: " + ((DoubleRoom) doubleRoom).roomPrice);


        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();
        System.out.println("Performing maintenance for Single Room");
        singleRoom.accept(maintenanceVisitor);
    }
}
