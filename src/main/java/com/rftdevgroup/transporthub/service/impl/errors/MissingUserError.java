package com.rftdevgroup.transporthub.service.impl.errors;

public class MissingUserError extends AuctionError {
    public MissingUserError(){
        this.setMessage("Missing user.");
    }
}
