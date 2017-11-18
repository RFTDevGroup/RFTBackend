package com.rftdevgroup.transporthub.validator.field;

import com.rftdevgroup.transporthub.data.model.transport.Cargo;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class CargoValidator implements ObjectFieldValidator<Cargo> {
    @Override
    public void validate(String fieldname, Cargo cargo, ValidationErrors errors) {
        if (cargo.getDepth() == 0.0) errors.addFieldError(fieldname + ".depth", "Field has null value");
        if (cargo.getHeight() == 0.0) errors.addFieldError(fieldname + ".height", "Field has null value");
        if (cargo.getWeight() == 0.0) errors.addFieldError(fieldname + ".weight", "Field has null value");
        if (cargo.getWidth() == 0.0) errors.addFieldError(fieldname + ".width", "Field has null value");
        if (cargo.getName() == null || cargo.getName().isEmpty()) errors.addFieldError(fieldname + ".name", "Field is empty");
        if (cargo.getDescription() == null || cargo.getDescription().isEmpty()) errors.addFieldError(fieldname + ".name", "Field is empty");
    }
}
