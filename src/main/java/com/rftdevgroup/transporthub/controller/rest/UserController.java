package com.rftdevgroup.transporthub.controller.rest;

import com.rftdevgroup.transporthub.controller.response.Response;
import com.rftdevgroup.transporthub.controller.response.ResponseStatus;
import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.dto.UserUpdateDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.UserRepository;
import com.rftdevgroup.transporthub.service.UserService;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import com.rftdevgroup.transporthub.validator.Validators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
    private Validators validators;

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
    public Response updateSelf(Principal principal, @RequestBody UserUpdateDTO updateDTO) {
        Optional<ValidationErrors> errors = validators.validate(updateDTO);
        if(errors.isPresent()){
            return new Response(ResponseStatus.VALIDATION_ERROR, errors.get());
        }
        Optional<UserDTO> activeUser = userService.findAndMapUser(principal.getName(), UserDTO.class);
        if (activeUser.isPresent()) {
            UserDTO updatedUser = userService.updateUser(activeUser.get().getId(), updateDTO);
            if(updateDTO != null){
                return new Response(ResponseStatus.OK, updatedUser);
            } else {
                return new Response(ResponseStatus.INTERNAL_ERROR, "Update process failed!");
            }
        } else {
            return new Response(ResponseStatus.INTERNAL_ERROR, "No active user is present.");
        }
    }

}
