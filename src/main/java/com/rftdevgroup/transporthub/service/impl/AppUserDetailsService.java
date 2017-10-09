package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.model.User;
import com.rftdevgroup.transporthub.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUserName(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), authorityList);

        return userDetails;
    }
}
