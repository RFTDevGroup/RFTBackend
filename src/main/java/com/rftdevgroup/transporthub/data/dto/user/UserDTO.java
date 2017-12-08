package com.rftdevgroup.transporthub.data.dto.user;

import com.rftdevgroup.transporthub.data.model.user.Address;
import com.rftdevgroup.transporthub.data.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Detailed DTO containing extra information for the {@link User}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private List<String> roles;
}
