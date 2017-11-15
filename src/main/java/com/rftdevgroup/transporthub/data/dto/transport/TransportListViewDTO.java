package com.rftdevgroup.transporthub.data.dto.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportListViewDTO {
    private String cargoName;
    private String cityFrom;
    private String cityTo;
    private String description;
    private String daysRemaining;
    private String owner;
    private int currentPrice;
}
