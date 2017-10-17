package com.rftdevgroup.transporthub.data.dto;

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
    long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String address;
    List<String> roles;
}
