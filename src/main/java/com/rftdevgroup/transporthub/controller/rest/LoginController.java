package com.rftdevgroup.transporthub.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for providing authentication.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Authentication login(Authentication auth) {
        log.debug("User[{}] requested authentication.",auth.getDetails());
        return auth;
    }
}
