package com.rftdevgroup.transporthub.data.dto.transport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rftdevgroup.transporthub.configuration.converter.LocalDateDeserializer;
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
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate timeOfLoad;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate timeOfUnload;
    private long startingPrice;
}
