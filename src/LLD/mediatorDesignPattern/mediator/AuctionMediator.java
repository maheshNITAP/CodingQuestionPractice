package LLD.mediatorDesignPattern.mediator;

import LLD.mediatorDesignPattern.colleague.Colleague;

public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
