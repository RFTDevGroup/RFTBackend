package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.user.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserRegisterDTO;
import com.rftdevgroup.transporthub.service.UserService;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {

    @Autowired
    private Validators validators;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO registerDTO) {
        Optional<ValidationErrors> errors = validators.validate(registerDTO);
        if (!errors.isPresent()) {
            //return confirmation
            UserCredentialDTO newUser = userService.regiserUser(registerDTO);
            log.debug("New user[{}] created!",newUser.getUsername());
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } else {
            log.warn("Missing or incorrect data on registration form.");
            return new ResponseEntity<>(errors.get().getErrors(), HttpStatus.BAD_REQUEST);
        }
    }
}
