package com.rftdevgroup.transporthub.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Validators {

    @Autowired
    private List<Validator> validators;

    public void test() {
        for (Validator validator : validators) {
            System.out.println("found");
        }
    }
}
