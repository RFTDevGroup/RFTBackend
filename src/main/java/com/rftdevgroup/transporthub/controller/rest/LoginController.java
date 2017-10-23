package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import com.rftdevgroup.transporthub.data.model.user.Address;
import com.rftdevgroup.transporthub.data.model.user.Role;
import com.rftdevgroup.transporthub.data.model.user.UserDetails;
import com.rftdevgroup.transporthub.data.repository.AddressRepository;
import com.rftdevgroup.transporthub.data.repository.RoleRepository;
import com.rftdevgroup.transporthub.data.repository.UserDetailsRepository;
import com.rftdevgroup.transporthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Custom REST controller for testing purposes.
 * To be removed.
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserDetailsRepository detailsRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Authentication login(Authentication auth) {
        return auth;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public UserDTO test() {
        return userService.findAndMapUser("rftuser", UserDTO.class).get();
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Role> roles(){
        return roleRepository.findAll();
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public List<UserDetails> details(){
        return detailsRepository.findAll();
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public List<Address> addresses(){
        return addressRepository.findAll();
    }

}
