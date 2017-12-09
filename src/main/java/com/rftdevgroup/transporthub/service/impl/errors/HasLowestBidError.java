package com.rftdevgroup.transporthub.service.impl.errors;

public class HasLowestBidError extends AuctionError {
    public HasLowestBidError(){
        this.setMessage("You already have the lowest bid.");
    }
}
