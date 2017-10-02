package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.model.User;
import com.rftdevgroup.transporthub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users() {
        return userRepository.findAll();
    }
}
