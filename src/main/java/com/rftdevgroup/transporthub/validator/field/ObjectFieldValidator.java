package com.rftdevgroup.transporthub.validator.field;

import com.rftdevgroup.transporthub.validator.ValidationErrors;

public interface ObjectFieldValidator<T> {
    void validate(String fieldname, T object, ValidationErrors errors);
}
