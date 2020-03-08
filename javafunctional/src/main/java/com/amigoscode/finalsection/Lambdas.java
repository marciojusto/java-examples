package com.amigoscode.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> name.toUpperCase();
        System.out.println(upperCaseName.apply("marcio"));

        Function<String, String> upperCaseName2 = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be Blank!");
            return name.toUpperCase();
        };
        System.out.println(upperCaseName2.apply("pedro"));

        BiFunction<String, Integer, String> upperCaseName3 = (name, age) -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be Blank!");
            return name.toUpperCase().concat(" have ".concat(age.toString()));
        };

        System.out.println(upperCaseName3.apply("augusto", 20));

    }
}
