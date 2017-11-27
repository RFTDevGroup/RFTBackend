package com.rftdevgroup.transporthub.data.repository.auction;

import com.rftdevgroup.transporthub.data.model.auction.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
