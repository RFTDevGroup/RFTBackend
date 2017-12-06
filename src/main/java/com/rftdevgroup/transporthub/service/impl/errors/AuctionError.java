package com.rftdevgroup.transporthub.service.impl.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuctionError extends Throwable {
    private String message;

    public AuctionError(String message) {
        this.message = message;
    }
}
