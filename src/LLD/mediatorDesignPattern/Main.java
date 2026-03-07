package LLD.mediatorDesignPattern;

import LLD.mediatorDesignPattern.colleague.Bidder;
import LLD.mediatorDesignPattern.colleague.Colleague;
import LLD.mediatorDesignPattern.mediator.Auction;
import LLD.mediatorDesignPattern.mediator.AuctionMediator;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMObj= new Auction();
        Colleague bidder1 = new Bidder("Mahesh", auctionMObj);
        Colleague bidder2 = new Bidder("Sankar", auctionMObj);
        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder1.placeBid(4000);
    }
}
