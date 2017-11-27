package com.rftdevgroup.transporthub.data.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private String country;
    private String zipcode;
    private String city;
    private String street;
    private String houseNo;
}
