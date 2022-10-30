package com.practice.functionalprogramming.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

// Its a normal function
public class _Function {

  public static void main(String[] args) {
    // sout
    int incrementByOne = incrementByOne(0);
    System.out.println(incrementByOne);

    int incrementByOneFunctional = incrementByOneFunction.apply(1);
    System.out.println(incrementByOneFunctional);

    int multiplyBy10 = multiplyBy10Function.apply(incrementByOneFunctional);
    System.out.println(multiplyBy10);

    Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(
      multiplyBy10Function
    );
    System.out.println(addBy1AndThenMultiplyBy10.apply(4));

    System.out.println(incrementByOneAndMultiplyBy(4, 100));
    System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
  }

  // Represents a function that accepts ONE argument (Integer) and produces a result (Integer).
  static Function<Integer, Integer> incrementByOneFunction = number ->
    number = number + 1;

  static Function<Integer, Integer> multiplyBy10Function = number ->
    number * 10;

  static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (numberToIncrementBy1, numberToMultiplyBy) ->
    (numberToIncrementBy1 + 1) * numberToMultiplyBy;

  // Imperative functions.
  static int incrementByOne(int number) {
    return number + 1;
  }

  static int incrementByOneAndMultiplyBy(int number, int multiplyBy) {
    return (number + 1) * multiplyBy;
  }
}
