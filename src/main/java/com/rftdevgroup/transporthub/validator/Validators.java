package com.rftdevgroup.transporthub.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class Validators {

    @Autowired
    private List<Validator> validators;

    public Optional<ValidationErrors> validate(Object o) {
        for (Validator validator : validators) {
            if (validator.isSupported(o.getClass())) {
                return validator.validate(o);
            }
        }
        return Optional.empty();
    }
}
