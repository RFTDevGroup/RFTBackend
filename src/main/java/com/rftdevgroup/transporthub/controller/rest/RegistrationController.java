package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.controller.response.Response;
import com.rftdevgroup.transporthub.controller.response.ResponseStatus;
import com.rftdevgroup.transporthub.data.dto.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import com.rftdevgroup.transporthub.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody UserRegisterDTO registerDTO) {
        Response response = new Response();
        if (validators.validate(registerDTO)) {
            //return confirmation
            UserCredentialDTO newUser = userService.regiserUser(registerDTO);
            //Role role = roleRepository.findByName("user");
            response.setStatus(ResponseStatus.OK);
            response.setResponseObject(newUser);
        } else {
            response.setStatus(ResponseStatus.VALIDATION_ERROR);
        }

        return response;
    }
}
