package com.practice.functionalprogramming.imperative;

// For using the MALE and FEMALE whitout typing the class before.
import static com.practice.functionalprogramming.imperative.Main.Gender.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

  // 'psvm' (Public Static Void Main) is the attach for the main.
  public static void main(String[] args) {
    List<Person> people = List.of(
      new Person("John", MALE),
      new Person("Maria", FEMALE),
      new Person("Josue", MALE),
      new Person("Josefina", FEMALE)
    );

    // Imperative approach
    System.out.println("\n// Imperative Approach: \n");

    List<Person> females = new ArrayList<>();

    for (Person person : people) {
      if (FEMALE.equals(person.gender)) females.add(person);
    }

    for (Person person : females) {
      System.out.println(person);
    }

    // Declarative approach
    System.out.println("\n// Declarative Approach: \n");

    Predicate<Person> predicatePerson = person -> FEMALE.equals(person.gender);

    people
      .stream()
      // .filter(person -> FEMALE.equals(person.gender))
      .filter(predicatePerson)
      .collect(Collectors.toList())
      .forEach(System.out::println);
  }

  static class Person {

    private final String name;
    private final Gender gender;

    Person(String name, Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    @Override
    public String toString() {
      return "Person{" + "name'" + name + '\'' + ", gender=" + gender + '}';
    }
  }

  enum Gender {
    MALE,
    FEMALE,
  }
}
