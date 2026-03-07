package LLD.visitorDesignPattern.element;

import LLD.visitorDesignPattern.visitor.RoomVisitor;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
