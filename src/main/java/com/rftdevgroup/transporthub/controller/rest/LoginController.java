package com.rftdevgroup.transporthub.controller.rest;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Authentication login(Authentication auth) {
        return auth;
    }
}
