package com.rftdevgroup.transporthub.controller;

import com.rftdevgroup.transporthub.model.User;
import com.rftdevgroup.transporthub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public List<User> users() {
        return userRepository.findAll();
    }
}
