package com.rftdevgroup.transporthub.validator.impl;

import com.rftdevgroup.transporthub.data.dto.transport.TransportCreateDTO;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validator;
import com.rftdevgroup.transporthub.validator.field.AddressValidator;
import com.rftdevgroup.transporthub.validator.field.CargoValidator;
import com.rftdevgroup.transporthub.validator.field.LocalDateValidator;
import com.rftdevgroup.transporthub.validator.field.LongValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TransportCreateDTOValidator implements Validator {

    @Autowired
    private AddressValidator addressValidator;
    @Autowired
    private CargoValidator cargoValidator;
    @Autowired
    private LocalDateValidator localDateValidator;
    @Autowired
    private LongValidator longValidator;

    @Override
    public Optional<ValidationErrors> validate(Object o) {
        ValidationErrors errors = new ValidationErrors();
        TransportCreateDTO dto = (TransportCreateDTO) o;

        addressValidator.validate("placeOfLoad", dto.getPlaceOfLoad(), errors);
        addressValidator.validate("placeOfUnload", dto.getPlaceOfUnload(), errors);
        cargoValidator.validate("cargo", dto.getCargo(), errors);
        localDateValidator.validate("timeOfLoad", dto.getTimeOfLoad(), errors);
        localDateValidator.validate("timeOfUnload", dto.getTimeOfUnload(), errors);
        longValidator.validate("startingPrice", dto.getStartingPrice(), errors);

        return errors.getErrors().isEmpty() ? Optional.empty() : Optional.of(errors);
    }

    @Override
    public boolean isSupported(Class c) {
        return c.equals(TransportCreateDTO.class);
    }
}
