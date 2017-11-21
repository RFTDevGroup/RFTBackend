package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.user.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserRegisterDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserUpdateDTO;
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
     * Finds a user with the given username and maps it to the specified class.
     * @param username the username of the user
     * @param mapTo the class to be maped to.
     * @param <T> the class to be mapped to
     * @return an {@link Optional} containing the mapped user if the user exists
     */
    <T> Optional<T> findAndMapUser(String username, Class<T> mapTo);

    UserCredentialDTO regiserUser(UserRegisterDTO registerDTO);

    boolean deleteUser(long id);

    UserDTO updateUser(long id, UserUpdateDTO updateDTO);
}
