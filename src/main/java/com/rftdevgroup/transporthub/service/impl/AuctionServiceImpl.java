package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.model.auction.Bid;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.auction.BidRepository;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.data.repository.user.UserRepository;
import com.rftdevgroup.transporthub.service.AuctionService;
import com.rftdevgroup.transporthub.service.impl.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.Optional;

@Service
@Slf4j
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void makeBid(long transportId, int amount, String username) throws AuctionError {
        //Grab components
        Transport transport = transportRepository.findOne(transportId);
        if (transport == null) {
            log.error("Transport({}) is missing.", transportId);
            throw new MissingTransportError();
        }
        Optional<User> bidder = userRepository.findUserByUserName(username);
        if (!bidder.isPresent()) {
            log.error("The bidding user({}) is missing.", username);
            throw new MissingUserError();
        }
        Bid bid = new Bid();

        //Check bidding amount
        if (amount >= transport.getCurrentPrice()) {
            log.error("The bidding amount({}) is higher than the current lowest bid().", amount, transport.getCurrentPrice());
            throw new InvalidAmountError();
        }
        //Check last bidder
        Optional<Bid> lastBid = transport.getBids().stream().min(Comparator.comparing(Bid::getAmount));
        if (lastBid.isPresent()) {
            if (lastBid.get().getBidder().equals(bidder.get())) {
                log.error("Bidder already has the lowest bid.");
                throw new HasLowestBidError();
            }
        }
        //Check owner cannot bid on his/her transport job
        if (transport.getOwner().equals(bidder.get())) {
            log.error("Transport owner cannot bid on his/her transport job.");
            throw new OwnerBiddingError();
        }
        //Make new bid
        bid.setBidder(bidder.get());
        bid.setTransport(transportRepository.findOne(transportId));
        bid.setAmount(amount);
        log.debug("Bid saved(bidder: {}, transport({}), Amount: {})", bidder.get().getUserName(), transportId, amount);
        bidRepository.save(bid);
    }
}
