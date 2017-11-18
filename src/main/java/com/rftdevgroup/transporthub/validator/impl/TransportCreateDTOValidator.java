package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validator;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TransportCreateDTOValidator implements Validator {
    @Override
    public Optional<ValidationErrors> validate(Object o) {
        ValidationErrors errors = new ValidationErrors();
        TransportCreateDTO dto = (TransportCreateDTO) o;

        return errors.getErrors().isEmpty() ? Optional.empty() : Optional.of(errors);
    }

    @Override
    public boolean isSupported(Class c) {
        return c.equals(TransportCreateDTO.class);
    }
}
