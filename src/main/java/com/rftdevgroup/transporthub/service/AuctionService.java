package com.rftdevgroup.transporthub.service;

import java.security.Principal;

public interface AuctionService {
    boolean makeBid(long transportId, int amount, String username);
}
