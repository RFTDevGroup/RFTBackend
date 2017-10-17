package com.rftdevgroup.transporthub.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * A token containing the logged in user's information.
 * To Be Implemented.
 */
@Data
@NoArgsConstructor
public class UserToken {
    @Value("${something.value}")
    private String token;
}
