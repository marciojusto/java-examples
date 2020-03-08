package com.amigoscode.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object optional = Optional.ofNullable(null).orElseGet(() -> "Default value");
        System.out.println(optional);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannnot send email"));
    }
}
