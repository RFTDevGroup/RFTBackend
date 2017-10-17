package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    public ResponseEntity<UserCredentialDTO> register(@RequestBody UserRegisterDTO registerDTO) {



        return new ResponseEntity<UserCredentialDTO>(new UserCredentialDTO(), HttpStatus.OK);
    }
}
