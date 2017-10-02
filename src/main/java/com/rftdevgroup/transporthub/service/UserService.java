package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.data.model.User;
import java.util.List;

public interface UserService {
    List<UserDTO> listUsers();
}
