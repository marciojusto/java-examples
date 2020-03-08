package com.amigoscode.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

import static com.amigoscode.streams._Stream.Gender.*;

public class _Stream {

    static List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE),
            new Person("Bob", PREFER_NOT_TO_SAY)
    );

    public static void main(String[] args) {
        people.stream()
              .map(Person::getName)
              .sorted()
              .collect(Collectors.toSet())
              .forEach(System.out::println);

        people.stream()
              .map(Person::getName)
              .map(String::length)
              .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream().allMatch(person -> FEMALE.equals(person.getGender()));
        System.out.println(containsOnlyFemales);
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;
    }
}
