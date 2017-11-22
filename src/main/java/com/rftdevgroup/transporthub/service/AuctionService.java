package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.service.impl.errors.AuctionError;

public interface AuctionService {
    boolean makeBid(long transportId, int amount, String username) throws AuctionError;
}
