package com.rftdevgroup.transporthub.data.dto;

import com.rftdevgroup.transporthub.data.model.user.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
