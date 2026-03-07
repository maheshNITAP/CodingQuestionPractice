package LLD.mediatorDesignPattern.colleague;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
