package com.practice.functionalprogramming.streams;

import static com.practice.functionalprogramming.streams._Stream.Gender.*;

import java.util.List;
import java.util.stream.Collectors;

public class _Stream {

  public static void main(String[] args) {
    List<Person> people = List.of(
      new Person("John", MALE),
      new Person("Maria", FEMALE),
      // new Person("Bob", PREFER_NOT_TO_SAY),
      new Person("Josue", MALE),
      new Person("Josefina", FEMALE)
    );

    people
      .stream()
      // His argument is a function that have 1 argument and 1 return;
      .map(person -> person.gender)
      // Collect all the elements into a set
      .collect(Collectors.toSet())
      // forEach is a Consumer (or void) function.
      .forEach(System.out::println);
    // .forEach( gender -> System.out.println(gender));

    people
      .stream()
      .map(person -> person.name)
      // .mapToInt(name -> name.length())
      .mapToInt(String::length)
      .forEach(System.out::println);

    boolean containsOnlyFemales = people
      .stream()
      .allMatch(person -> FEMALE.equals(person.gender));

    System.out.println(containsOnlyFemales);

    boolean notContainsPNTS = people
      .stream()
      .noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));

    System.out.println(notContainsPNTS);
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
    PREFER_NOT_TO_SAY,
  }
}
