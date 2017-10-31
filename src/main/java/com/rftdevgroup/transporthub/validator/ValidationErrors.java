package com.rftdevgroup.transporthub.validator;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrors {

    private List<ValidationError> errors;

    public ValidationErrors() {
        this.errors = new ArrayList<>();
    }

    public void addFieldError(String field, String message){
        errors.add(new ValidationError(message, field));
    }
}
