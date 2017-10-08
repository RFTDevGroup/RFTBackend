package com.rftdevgroup.transporthub.configuration.security;

import com.rftdevgroup.transporthub.data.dto.UserDTO;
import com.rftdevgroup.transporthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<UserDTO> user = userService.findUser(username);

        if (user.isPresent()) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
