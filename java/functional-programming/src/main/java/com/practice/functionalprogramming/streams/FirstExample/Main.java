package com.practice.functionalprogramming.streams.FirstExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Person> people = getPeople();

    // ❌ Imperative Approach:
    List<Person> females = new ArrayList<>();
    for (Person person : people) {
      if (person.getGender().equals(Gender.FEMALE)) females.add(person);
    }
    // females.forEach(System.out::println);

    // ✅ Declarative Approach:

    // filter
    System.out.println("\nFilter:");
    people
      .stream()
      .filter(person -> person.getGender().equals(Gender.FEMALE))
      .collect(Collectors.toList())
      .forEach(System.out::println);

    // sort
    System.out.println("\nSort:");
    people
      .stream()
      .sorted(Comparator.comparing(Person::getAge))
      .collect(Collectors.toList())
      .forEach(System.out::println);

    // all match
    System.out.println("\nAll Match:");
    boolean allMatch = people.stream().allMatch(person -> person.getAge() > 5);
    System.out.println("Are all of people greater than 5 years? " + allMatch);

    // any match
    System.out.println("\nAny Match:");
    boolean anyMatch = people
      .stream()
      .anyMatch(person -> person.getAge() > 120);
    System.out.println(
      "Do we have any match which is bigger than 120 years? " + anyMatch
    );

    // none match
    System.out.println("\nAll Match:");
    boolean noneMatch = people
      .stream()
      .noneMatch(person -> person.getName().equals("Antonio"));
    System.out.println("Antonio is not on the list: " + noneMatch);

    // max
    System.out.println("\nMax:");
    people
      .stream()
      .max(Comparator.comparing(Person::getAge))
      .ifPresent(System.out::println);

    // min
    System.out.println("\nMin:");
    people
      .stream()
      .min(Comparator.comparing(Person::getAge))
      .ifPresent(System.out::println);

    // group
    System.out.println("\nGroup:");
    Map<Gender, List<Person>> groupByGender = people
      .stream()
      .sorted(Comparator.comparing(Person::getAge))
      .collect(Collectors.groupingBy(Person::getGender));

    groupByGender.forEach(
      (gender, people1) -> {
        System.out.println(gender);
        people1.forEach(System.out::println);
        System.out.println();
      }
    );

    // mix
    System.out.println("\nOldest female:");
    people
      .stream()
      .filter(person -> person.getGender().equals(Gender.FEMALE))
      .max(Comparator.comparing(Person::getAge))
      .map(Person::getName)
      .ifPresent(System.out::println);

    System.out.println();
  }

  private static List<Person> getPeople() {
    return List.of(
      new Person("Canor orli", 22, Gender.MALE),
      new Person("Raynera", 16, Gender.FEMALE),
      new Person("Maria Herrera", 45, Gender.FEMALE),
      new Person("Nabucodonosor dosor", 70, Gender.MALE),
      new Person("Juan cruz", 7, Gender.MALE)
    );
  }
}
