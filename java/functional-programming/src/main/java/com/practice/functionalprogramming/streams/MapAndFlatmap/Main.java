package com.practice.functionalprogramming.streams.MapAndFlatmap;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<SchoolClass> schoolClasses = createSchoolClasses();

    System.out.println("\nStudent's list using map --> Return a list of lists");
    List<List<String>> listsStudents = schoolClasses
      .stream()
      .map(
        schoolClass ->
          schoolClass
            .getStudents()
            .stream()
            .map(Student::getName)
            .collect(Collectors.toList())
      )
      .collect(Collectors.toList());
    System.out.println(listsStudents);

    System.out.println(
      "\nStudent's list using flatMap --> Returns a flat list of the students"
    );
    List<String> studentNames = schoolClasses
      .stream()
      .flatMap(
        schoolClass -> schoolClass.getStudents().stream().map(Student::getName)
      )
      .collect(Collectors.toList());
    System.out.println(studentNames);
  }

  private static List<SchoolClass> createSchoolClasses() {
    SchoolClass canorClass = new SchoolClass("Canor");
    canorClass.addStudent(new Student("Alberto", 69, "+549-2142-4423"));
    canorClass.addStudent(new Student("Julian", 22, "+01-8484-7263"));
    canorClass.addStudent(new Student("Maria", 45, "+55-1243-4444"));

    SchoolClass christinaClass = new SchoolClass("Christina");
    christinaClass.addStudent(new Student("Julieta", 18, "+549-3333-4444"));
    christinaClass.addStudent(new Student("Dylan", 10, "41-1234-56787"));
    christinaClass.addStudent(new Student("Abigail", 27, "+11-4512-786412"));
    christinaClass.addStudent(
      new Student("nabucodonosor", 80, "+88-34723-232")
    );

    return List.of(canorClass, christinaClass);
  }
}
