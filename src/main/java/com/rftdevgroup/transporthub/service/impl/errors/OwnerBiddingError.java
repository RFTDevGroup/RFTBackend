package com.rftdevgroup.transporthub.service.impl.errors;

public class OwnerBiddingError extends AuctionError {
    public OwnerBiddingError(){
        this.setMessage("You cannot bid on your own transport job.");
    }
}
