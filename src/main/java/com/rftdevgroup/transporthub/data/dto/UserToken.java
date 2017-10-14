package com.rftdevgroup.transporthub.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
public class UserToken {
    @Value("${something.value}")
    private String token;
}
