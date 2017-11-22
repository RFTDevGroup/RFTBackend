package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.model.auction.Bid;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.auction.BidRepository;
import com.rftdevgroup.transporthub.data.repository.transport.TransportRepository;
import com.rftdevgroup.transporthub.data.repository.user.UserRepository;
import com.rftdevgroup.transporthub.service.AuctionService;
import com.rftdevgroup.transporthub.service.impl.errors.AuctionError;
import com.rftdevgroup.transporthub.service.impl.errors.InvalidAmountError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean makeBid(long transportId, int amount, String username) throws AuctionError{
        Transport transport = transportRepository.findOne(transportId);
        if (transport == null) return false;
        if (amount >= transport.getCurrentPrice()) throw new InvalidAmountError();
        Bid bid = new Bid();
        Optional<User> bidder = userRepository.findUserByUserName(username);
        if (!bidder.isPresent()) return false;
        bid.setBidder(bidder.get());
        bid.setTransport(transportRepository.findOne(transportId));
        bid.setAmount(amount);

        bidRepository.save(bid);
        return true;
    }
}
