package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import com.rftdevgroup.transporthub.validator.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private Validators validators;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserRegisterDTO register(@RequestBody UserRegisterDTO registerDTO) {
        validators.test();
        return registerDTO;
    }
}
