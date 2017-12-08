package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.auction.PlaceBidDTO;
import com.rftdevgroup.transporthub.data.model.auction.Bid;
import com.rftdevgroup.transporthub.data.repository.auction.BidRepository;
import com.rftdevgroup.transporthub.service.AuctionService;
import com.rftdevgroup.transporthub.service.impl.errors.AuctionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionService auctionService;

    @Secured(ADMIN)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Bid> bids() {
        return bidRepository.findAll();
    }

    @Secured(USER)
    @RequestMapping(value = "/transport/{id}/bid", method = RequestMethod.POST)
    public ResponseEntity<?> makeBid(@PathVariable("id") long transportId, @RequestBody PlaceBidDTO bidDTO, Principal principal) {
        try {
            auctionService.makeBid(transportId, bidDTO.getAmount(), principal.getName());
            return new ResponseEntity<>("Bid placed.", HttpStatus.OK);
        } catch (AuctionError auerr) {
            return new ResponseEntity<>(auerr.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
