package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.UserUpdateDTO;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validator;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class UserUpdateDTOValidator implements Validator {
    @Override
    public Optional<ValidationErrors> validate(Object o) {
        ValidationErrors errors = new ValidationErrors();
        errors.addFieldError("asd","blah blah");
        return Optional.of(errors);
    }

    @Override
    public boolean isSupported(Class c) {
        return UserUpdateDTO.class.equals(c);
    }
}
