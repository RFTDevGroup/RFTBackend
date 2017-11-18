package com.rftdevgroup.transporthub.data.dto.transport;

import com.rftdevgroup.transporthub.data.model.transport.Cargo;
import com.rftdevgroup.transporthub.data.model.user.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportCreateDTO {
    private Cargo cargo;
    private Address placeOfLoad;
    private Address placeOfUnload;
    private LocalDate timeOfLoad;
    private LocalDate timeOfUnload;
    private long startingPrice;
}
