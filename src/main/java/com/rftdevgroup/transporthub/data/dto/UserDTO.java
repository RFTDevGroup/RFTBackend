package com.rftdevgroup.transporthub.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Simple DTO for the {@link com.rftdevgroup.transporthub.data.model.User}.
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
