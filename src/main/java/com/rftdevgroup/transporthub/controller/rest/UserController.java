package com.rftdevgroup.transporthub.controller.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rftdevgroup.transporthub.controller.response.Response;
import com.rftdevgroup.transporthub.controller.response.ResponseStatus;
import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.dto.UserRegisterDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.UserRepository;
import com.rftdevgroup.transporthub.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller class for providing endpoints to {@link User} related operations.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private static final String ADMIN = "ROLE_ADMIN";
    private static final String USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Value("${something.value}")
    private String test;

    @Secured(ADMIN)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> users() {
        return userService.listUsers();
    }

    @Secured(ADMIN)
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public Response deleteUser(@PathVariable("userId") long userId, Principal principal) {
        //delete user
        if (userService.deleteUser(userId)) {
            return new Response(ResponseStatus.OK, principal.getName() + " deleted user id: " + userId);
        } else {
            return new Response(ResponseStatus.INTERNAL_ERROR, "Something went terribly wrong!");
        }

    }

    @Secured(USER)
    @RequestMapping(value = "/user/update", method = RequestMethod.PUT)
    public Response updateSelf(Principal principal, @RequestBody Object request) {
        User sample = repository.findOne(1L);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        modelMapper.map(request, sample);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return new Response(ResponseStatus.OK,sample);
    }

}
