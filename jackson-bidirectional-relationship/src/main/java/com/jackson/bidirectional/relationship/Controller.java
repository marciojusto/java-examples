package com.jackson.bidirectional.relationship;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class Controller {

    @GetMapping("/test-users")
    public ResponseEntity<List<User>> getUserList() {

        List<User> users = new ArrayList<>();

        Role role = new Role();
        role.setId(20);
        role.setName("Super User");

        User user = new User();
        user.setId(1);
        user.setName("Alex");
        user.setRole(role);
        role.setUsers(users);

        users.add(user);

        for (User u : users) {
            u.getRole().setUsers(null);
        }

        return new ResponseEntity<List<User>>(users, OK);
    }

    @GetMapping("/test-role")
    public ResponseEntity<Role> getRole() {

        List<Role> roles = new ArrayList<>();

        Role role = new Role();
        role.setId(20);
        role.setName("Super User");

        User user = new User();
        user.setId(1);
        user.setName("Alex");
        user.setRole(role);

        List<User> users = new ArrayList<>();
        users.add(user);
        role.setUsers(users);

        return new ResponseEntity<Role>(role, OK);
    }
}
