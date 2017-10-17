package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import java.util.List;
import java.util.Optional;

/**
 * A service class describing operations for {@link User}s.
 */
public interface UserService {

    /**
     * Lists all users in the application.
     * @return A {@link List} of {@link UserDTO}s mapped from the {@link User}s in the application
     */
    List<UserDTO> listUsers();

    /**
     * Finds a user's credentials with the specified username.
     * @param username the username of the user
     * @return an {@link Optional} {@link UserCredentialDTO} with the credentials of the given user
     */
    Optional<UserCredentialDTO> findUserCredentials(String username);

    /**
     * Finds a user with the given username and maps it to the specified class.
     * @param username the username of the user
     * @param mapTo the class to be maped to.
     * @param <T> the class to be mapped to
     * @return an {@link Optional} containing the mapped user if the user exists
     */
    <T> Optional<T> findAndMapUser(String username, Class<T> mapTo);
}
