package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> listUsers();

    Optional<UserDTO> findUser(String username);
}
