package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.service.impl.errors.AuctionError;

public interface AuctionService {
    void makeBid(long transportId, int amount, String username) throws AuctionError;
}
