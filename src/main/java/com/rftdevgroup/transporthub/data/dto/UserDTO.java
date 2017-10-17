package com.rftdevgroup.transporthub.data.dto;

import com.rftdevgroup.transporthub.data.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Simple DTO for the {@link User}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    long id;
    String userName;
    String password;
    List<String> roles;
}
