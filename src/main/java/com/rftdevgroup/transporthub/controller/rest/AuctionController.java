package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.model.auction.Bid;
import com.rftdevgroup.transporthub.data.repository.auction.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private BidRepository bidRepository;

    @Secured(ADMIN)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Bid> bids() {
        return bidRepository.findAll();
    }
}
