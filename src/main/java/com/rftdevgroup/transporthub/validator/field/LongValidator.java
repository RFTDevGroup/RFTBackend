package com.rftdevgroup.transporthub.validator.field;

import com.rftdevgroup.transporthub.validator.ValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class LongValidator implements ObjectFieldValidator<Long> {
    @Override
    public void validate(String fieldname, Long object, ValidationErrors errors) {
        if(object == null || object == 0.0) errors.addFieldError(fieldname, "Value cannot be null or 0");
    }
}
