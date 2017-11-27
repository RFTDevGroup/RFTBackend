package com.rftdevgroup.transporthub.data.dto.auction;

import com.rftdevgroup.transporthub.data.dto.user.UserMinimalDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BidDTO {
    private UserMinimalDTO bidder;
    private int amount;
}
