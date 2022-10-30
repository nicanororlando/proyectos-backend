package com.practice.functionalprogramming.functionalInterface;

import java.util.function.Predicate;

// Its a boolean function
public class _Predicate {

  public static void main(String[] args) {
    System.out.println("\nNormal form:");
    System.out.println(isPhoneNumberValid("07000000000"));
    System.out.println(isPhoneNumberValid("09000923400"));

    System.out.println("\nFunctional form:");
    System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
    System.out.println(isPhoneNumberValidPredicate.test("09000923400"));

    System.out.println(
      "Is phone number valid OR contains number 3: " +
      isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000")
    );
    System.out.println(
      "Is phone number valid AND contains number 3: " +
      isPhoneNumberValidPredicate.and(containsNumber3).test("07000030000")
    );
  }

  // Functional form
  static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
    phoneNumber.startsWith("07") && phoneNumber.length() == 11;

  static Predicate<String> containsNumber3 = phoneNumber ->
    phoneNumber.contains("3");

  // Normal form
  static boolean isPhoneNumberValid(String phoneNumber) {
    return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
  }
}
