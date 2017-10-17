package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.UserRepository;
import com.rftdevgroup.transporthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * REST Controller class for providing endpoints to {@link User} related operations.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${something.value}")
    private String test;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> users() {
        return userService.listUsers();
    }

}
