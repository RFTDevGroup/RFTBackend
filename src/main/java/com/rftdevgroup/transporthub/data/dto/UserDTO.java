package com.rftdevgroup.transporthub.data.dto;

import com.rftdevgroup.transporthub.data.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    long id;
    String userName;
    String password;
}
