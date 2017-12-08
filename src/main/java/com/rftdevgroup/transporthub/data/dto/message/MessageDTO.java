package com.rftdevgroup.transporthub.data.dto.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO {
    private String sender;
    private String to;
    private String topic;
    private String body;
    private boolean read;
}
