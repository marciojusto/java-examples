package com.amigoscode.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Customer {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;
}
