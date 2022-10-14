package com.practice.functionalprogramming.finalSection;

import java.util.function.BiConsumer;

public class _Primitives {

  public static void main(String[] args) {
    // This is an object:
    Integer number = null;

    // This is the primitive version of an integer. We cannot do this, because it is not an object.
    // int numberPrimitive = null;
    // In this case we have to initialize by a number:
    int numberPrimitive = 0;

    numbers(number, numberPrimitive);
    numbersFunctional.accept(number, null);
  }

  // We cannot do this:
  // static BiConsumer<Integer, int> numbersFunctional = (number, numberPrimitive) -> System.out.println("asd");
  // We are not allowed to use primitives in Functions, because in this case we aren't allowed to pass null
  static BiConsumer<Integer, Integer> numbersFunctional = (number, numberPrimitive) ->
    System.out.println("numbersFunctional");

  static void numbers(Integer number, int numberPrimitive) {
    System.out.println("numbers");
  }
}
