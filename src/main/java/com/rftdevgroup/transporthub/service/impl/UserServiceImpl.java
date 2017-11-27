package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.user.UserCredentialDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserRegisterDTO;
import com.rftdevgroup.transporthub.data.dto.user.UserUpdateDTO;
import com.rftdevgroup.transporthub.data.model.user.Role;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.user.AddressRepository;
import com.rftdevgroup.transporthub.data.repository.user.RoleRepository;
import com.rftdevgroup.transporthub.data.repository.user.UserRepository;
import com.rftdevgroup.transporthub.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * An implementation of the {@link UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <T> Optional<T> findAndMapUser(String username, Class<T> mapTo) {
        Optional<User> user = userRepository.findUserByUserName(username);
        return user.isPresent() ? Optional.of(modelMapper.map(user.get(), mapTo)) : Optional.empty();
    }

    @Override
    public <T> Optional<T> findAndMapUser(long id, Class<T> mapTo) {
        User user = userRepository.findOne(id);
        return user == null ? Optional.empty() : Optional.of(modelMapper.map(user, mapTo));
    }

    @Override
    public List<UserDTO> listUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserCredentialDTO regiserUser(UserRegisterDTO registerDTO) {
        Assert.notNull(registerDTO, "Register dto must not be null.");
        User userToSave = modelMapper.map(registerDTO, User.class);
        Role role = roleRepository.findByName("user");
        userToSave.setRoles(Arrays.asList(role));
        User saved = userRepository.save(userToSave);
        return modelMapper.map(saved, UserCredentialDTO.class);
    }

    @Override
    public boolean deleteUser(long id) {
        if (id == 0) return false;

        User userToBeDeleted = userRepository.findOne(id);
        if (userToBeDeleted == null) return false;

        userRepository.delete(userToBeDeleted);

        return true;
    }

    @Override
    public UserDTO updateUser(long id, UserUpdateDTO updateDTO) {
        Assert.notNull(updateDTO, "User update dto must not be null.");
        User userToUpdate = userRepository.findOne(id);
        if (userToUpdate != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
            modelMapper.map(updateDTO, userToUpdate.getDetails());
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            User saved = userRepository.save(userToUpdate);
            return modelMapper.map(saved, UserDTO.class);
        }
        return null;
    }
}
