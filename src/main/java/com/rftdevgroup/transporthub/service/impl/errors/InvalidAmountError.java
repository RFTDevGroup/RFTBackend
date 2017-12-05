package com.rftdevgroup.transporthub.service.impl.errors;

public class InvalidAmountError extends AuctionError {
    public InvalidAmountError() {
        this.setMessage("Invalid amount.");
    }
}
