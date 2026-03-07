package LLD.mediatorDesignPattern.mediator;

import LLD.mediatorDesignPattern.colleague.Colleague;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{
    List<Colleague> colleagueList = new ArrayList<>();
    @Override
    public void addBidder(Colleague bidder) {
        colleagueList.add(bidder);
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        for(Colleague colleague :colleagueList){
            if(!colleague.getName().equalsIgnoreCase(bidder.getName())){
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }
}
