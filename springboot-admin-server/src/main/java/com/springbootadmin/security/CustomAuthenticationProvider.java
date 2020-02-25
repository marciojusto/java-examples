package com.springbootadmin.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    List<User> dummyUsers = new ArrayList<>();

    public CustomAuthenticationProvider() {
        dummyUsers.add(new User("marcio", "justo", AuthorityUtils.createAuthorityList("ROLE_USER")));
        dummyUsers.add(new User("admin", "admin", AuthorityUtils.createAuthorityList("ROLE_ADMIN")));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> authenticatedUser = dummyUsers.stream()
                                                     .filter(user -> user.getUsername().equals(name) &&
                                                             user.getPassword().equals(password))
                                                     .findFirst();

        if(!authenticatedUser.isPresent()){
            throw new BadCredentialsException("User unothorized!");
        }

        return new UsernamePasswordAuthenticationToken(name, password, authenticatedUser.get().getAuthorities());
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
