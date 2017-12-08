package com.rftdevgroup.transporthub.service.impl.errors;

public class MissingTransportError extends AuctionError{
    public MissingTransportError(){
        this.setMessage("Missing transport.");
    }
}
