package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.data.dto.user.UserUpdateDTO;
import com.rftdevgroup.transporthub.data.model.user.Address;
import com.rftdevgroup.transporthub.data.model.user.Role;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.model.user.UserDetails;
import com.rftdevgroup.transporthub.data.repository.user.AddressRepository;
import com.rftdevgroup.transporthub.data.repository.user.RoleRepository;
import com.rftdevgroup.transporthub.data.repository.user.UserDetailsRepository;
import com.rftdevgroup.transporthub.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Authentication login(Authentication auth) {
        return auth;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public User test() {
        User usera = new User();
        usera.setDetails(new UserDetails());
        usera.setUserName("My username");
        UserUpdateDTO update = new UserUpdateDTO();
        update.setFirstName("first name");
        update.setLastName("last name");
        modelMapper.map(update, usera);

        return usera;
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
