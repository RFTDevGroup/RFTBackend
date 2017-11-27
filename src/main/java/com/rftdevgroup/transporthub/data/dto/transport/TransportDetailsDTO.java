package com.rftdevgroup.transporthub.data.dto.transport;

import com.rftdevgroup.transporthub.data.dto.auction.BidDTO;
import com.rftdevgroup.transporthub.data.dto.user.AddressDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class TransportDetailsDTO {
    private TransportOwnerDTO owner;
    private CargoDTO cargo;
    private AddressDTO placeOfLoad;
    private LocalDate timeOfLoad;
    private AddressDTO placeofUnload;
    private LocalDate timeOfUnload;
    private List<BidDTO> bids;

    public int getCurrentPrice() {
        return bids.stream().mapToInt(b -> b.getAmount()).min().getAsInt();
    }
}
