package com.practice.functionalprogramming.finalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Lambdas {

  public static void main(String[] args) {
    Function<String, String> upperCaseName = name -> name.toUpperCase();
    System.out.println(upperCaseName.apply("jose"));

    Function<String, String> upperCaseName2 = String::toUpperCase;
    System.out.println(upperCaseName2.apply("mauricio"));

    BiFunction<String, Integer, String> upperCaseName4 = (name, age) -> {
      if (name.isBlank()) throw new IllegalArgumentException("");
      System.out.println(age);
      return name.toUpperCase();
    };

    System.out.println(upperCaseName4.apply("Alex", 20));
  }
}
