package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.user.UserRegisterDTO;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validator;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class UserRegisterDTOValidator implements Validator {

    @Override
    public Optional<ValidationErrors> validate(Object o) {
        ValidationErrors errors = new ValidationErrors();
        UserRegisterDTO registerDTO = (UserRegisterDTO) o;
        if(registerDTO.getUserName() == null || registerDTO.getUserName().isEmpty()){
            errors.addFieldError("userName", "Username is empty.");
        }

        if(registerDTO.getUserName() == null || registerDTO.getUserName().length() < 5){
            errors.addFieldError("userName", "Username must be longer than 4 characters.");
        }

        if(registerDTO.getEmail() == null || registerDTO.getEmail().isEmpty()){
            errors.addFieldError("email", "Email is empty.");
        }

        if(registerDTO.getPassword() == null || registerDTO.getPassword().isEmpty()){
            errors.addFieldError("password", "Password is empty.");
        }

        return errors.getErrors().isEmpty() ? Optional.empty() : Optional.of(errors);
    }

    @Override
    public boolean isSupported(Class c) {
        return UserRegisterDTO.class.equals(c);
    }
}
