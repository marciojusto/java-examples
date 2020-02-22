package com.jackson.bidirectional.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"name", "users"})
public class Role {

    private int id;
    private String name;
    private List<User> users;
}



