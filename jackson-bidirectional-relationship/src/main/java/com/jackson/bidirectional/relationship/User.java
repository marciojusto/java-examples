package com.jackson.bidirectional.relationship;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"name", "role"})
@JsonSerialize(using = UserSerializer.class)
public class User {

    private int id;
    private String name;
    private Role role;
}
