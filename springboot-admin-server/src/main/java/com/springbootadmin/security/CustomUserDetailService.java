package com.springbootadmin.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private static List<UserObject> users = new ArrayList<>();

    public CustomUserDetailService() {
        users.add(new UserObject("admin", passwordEncoder().encode("admin"), "ADMIN"));
        users.add(new UserObject("erin", passwordEncoder().encode("123"), "ADMIN"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserObject> user = users.stream()
                                         .filter(u -> u.userName.equals(username))
                                         .findAny();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }


        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(UserObject userObject) {
        return User.withUsername(userObject.userName)
                   .password(userObject.passWord)
                   .roles(userObject.role).build();
    }

    @Data
    @AllArgsConstructor
    private class UserObject {
        private String userName;
        private String passWord;
        private String role;
    }
}
