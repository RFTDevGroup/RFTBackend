package com.rftdevgroup.transporthub.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;

/**
 * A token containing the logged in user's information.
 * To Be Implemented.
 */
@Data
@NoArgsConstructor
public class UserCredentialDTO {
    private long id;
    private String username;
    private String password;
    private List<String> roles;
}
