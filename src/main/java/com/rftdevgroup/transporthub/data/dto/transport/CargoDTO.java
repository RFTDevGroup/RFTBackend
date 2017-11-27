package com.rftdevgroup.transporthub.data.dto.transport;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoDTO {
    private String name;
    private String description;
    private long weight;
    private double width;
    private double height;
    private double depth;
}
