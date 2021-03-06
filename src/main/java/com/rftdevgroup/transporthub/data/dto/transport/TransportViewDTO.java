package com.rftdevgroup.transporthub.data.dto.transport;

import com.rftdevgroup.transporthub.data.model.transport.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportViewDTO {
    private String userName;
    private Cargo cargo;
    private int currentPrice;
}
