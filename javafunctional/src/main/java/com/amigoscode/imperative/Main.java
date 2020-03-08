package com.amigoscode.imperative;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.amigoscode.imperative.Main.Gender.FEMALE;
import static com.amigoscode.imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("// Imperative Approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("// Declarative approach");
        people.stream()
              .filter(person -> FEMALE.equals(person.gender))
              .forEach(System.out::println);
    }

    enum Gender {
        MALE, FEMALE
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;
    }
}
