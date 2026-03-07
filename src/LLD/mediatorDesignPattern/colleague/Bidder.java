package LLD.mediatorDesignPattern.colleague;

import LLD.mediatorDesignPattern.mediator.AuctionMediator;

public class Bidder implements Colleague{
    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }
    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder : "+ name + " received a notification that someone has put a new bid of amount : " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
