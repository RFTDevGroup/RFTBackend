package com.rftdevgroup.transporthub.validator;

import java.util.Optional;

public interface Validator {
    Optional<ValidationErrors> validate(Object o);
    boolean isSupported(Class c);
}
