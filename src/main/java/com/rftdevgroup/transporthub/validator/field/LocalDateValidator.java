package com.rftdevgroup.transporthub.validator.field;

import com.rftdevgroup.transporthub.validator.ValidationErrors;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class LocalDateValidator implements ObjectFieldValidator<LocalDate> {
    @Override
    public void validate(String fieldname, LocalDate date, ValidationErrors errors) {
        if (date == null) {
            errors.addFieldError(fieldname, "Field is empty.");
        } else if (date.isBefore(LocalDate.now())) errors.addFieldError(fieldname, "Cannot set date before today.");
    }
}
