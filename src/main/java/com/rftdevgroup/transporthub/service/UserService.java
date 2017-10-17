package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * A service class describing operations for {@link com.rftdevgroup.transporthub.data.model.User}s.
 */
public interface UserService {

    /**
     * Lists all users in the application.
     * @return A {@link List} of {@link UserDTO}s mapped from the {@link com.rftdevgroup.transporthub.data.model.User}s in the application
     */
    List<UserDTO> listUsers();

    /**
     * Finds a user with the specified username.
     * @param username the username of the user
     * @return an {@link Optional} {@link UserDTO} with the details of the given user
     */
    Optional<UserDTO> findUser(String username);
}
