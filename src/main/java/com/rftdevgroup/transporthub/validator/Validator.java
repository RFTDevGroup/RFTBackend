package com.rftdevgroup.transporthub.validator;

public interface Validator {
    boolean isValid(Object o);
    boolean isSupported(Class c);
}
