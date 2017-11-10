package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.user.UserUpdateDTO;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validator;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class UserUpdateDTOValidator implements Validator {
    @Override
    public Optional<ValidationErrors> validate(Object o) {
        UserUpdateDTO updateDTO = (UserUpdateDTO) o;
        ValidationErrors errors = new ValidationErrors();

        if(updateDTO.getFirstName() != null && updateDTO.getFirstName().isEmpty()){
            errors.addFieldError("firstName", "First Name is empty.");
        }

        if(updateDTO.getLastName() != null && updateDTO.getLastName().isEmpty()){
            errors.addFieldError("lastName", "Last Name is empty.");
        }

        if(updateDTO.getEmail() != null && updateDTO.getEmail().isEmpty()){
            errors.addFieldError("email", "Email is empty.");
        }

        if(updateDTO.getUserName() != null && updateDTO.getUserName().isEmpty()){
            errors.addFieldError("userName", "User name is empty.");
        }

        return errors.getErrors().isEmpty() ? Optional.empty() : Optional.of(errors);
    }

    @Override
    public boolean isSupported(Class c) {
        return UserUpdateDTO.class.equals(c);
    }
}
