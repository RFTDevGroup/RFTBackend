package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Custom REST controller for testing purposes.
 * To be removed.
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Authentication login(Authentication auth) {
        return auth;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public UserDTO test() {
        return userService.findAndMapUser("rftuser", UserDTO.class).get();
    }
}
