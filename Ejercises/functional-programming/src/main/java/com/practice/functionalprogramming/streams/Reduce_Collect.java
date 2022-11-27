package com.practice.functionalprogramming.streams;

import com.practice.functionalprogramming.streams.SchoolClassModel.SchoolClass;
import com.practice.functionalprogramming.streams.SchoolClassModel.Student;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce_Collect {

  public static void main(String[] args) {
    List<Integer> myNumbers = Arrays.asList(4, 5, 6, 7, 8);

    // Initial value = 0
    Optional<Integer> result = myNumbers
      .stream()
      // (accumulator, number) accumulator will be blank at first, then it will accumulate the values.
      .reduce((subtotal, number) -> subtotal + number);
    System.out.println("\n" + result.get());

    // With initial value
    System.out.println("\nInitial value: 5");
    Integer myResult = myNumbers
      .stream()
      .reduce(
        5,
        (subtotal, number) -> {
          System.out.println(subtotal);
          return subtotal + number;
        }
      );
    System.out.println(myResult);

    // ❌ Wrong use of reduce, because it is not a pure function:
    List<SchoolClass> schoolClasses = createSchoolClasses();
    SchoolClass maurucioClass = new SchoolClass("Mr. Maurucio");
    System.out.println(
      "Maurucio's's class premerge: " + maurucioClass.getStudents()
    );
    System.out.println(
      "Maurucio's class size: " + maurucioClass.getStudents().size()
    );

    schoolClasses
      .stream()
      .reduce(
        maurucioClass,
        (compressedClass, closingClass) -> {
          System.out.println("Closing " + closingClass.getName());
          compressedClass.getStudents().addAll(closingClass.getStudents());

          System.out.println(
            "Maurucio's class increased to: " +
            maurucioClass.getStudents().size()
          );
          return compressedClass;
        }
      );
    System.out.println(maurucioClass.getStudents());

    // ✅ Using collect: we are applying pure functions:
    System.out.println("\n\nUSING COLLECT:");

    SchoolClass mauricioClass2 = schoolClasses
      .stream()
      .collect(
        () -> new SchoolClass(),
        // (schoolClass, classToMerge) -> schoolClass.merge(classToMerge),
        SchoolClass::merge,
        SchoolClass::merge
      );

    System.out.println(
      "Mauricio's class post merge: " + mauricioClass2.getStudents()
    );
    System.out.println(
      "Mauricio's class size: " + mauricioClass2.getStudents().size()
    );
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
