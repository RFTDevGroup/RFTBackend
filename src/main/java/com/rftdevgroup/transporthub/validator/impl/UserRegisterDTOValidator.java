package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import com.rftdevgroup.transporthub.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterDTOValidator implements Validator{
    @Override
    public boolean isValid(Object o) {
        UserRegisterDTO registerDTO = (UserRegisterDTO) o;
        return registerDTO.getName().length() > 5;
    }

    @Override
    public boolean isSupported(Class c) {
        return UserRegisterDTO.class.equals(c);
    }
}
