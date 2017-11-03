package com.rftdevgroup.transporthub.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private ResponseStatus status;
    private Object responseObject;
}
