package com.practice.functionalprogramming.combinatorPattern;

import static com.practice.functionalprogramming.combinatorPattern.CustomerRegistrationValidation.*;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    Customer customer = new Customer(
      "Alice",
      "alicenoseq@gmail.com",
      "+084922332",
      LocalDate.of(2000, 1, 1)
    );
    // System.out.println(new CustomerValidatorService().isValid(customer));

    // Using combinator pattern:
    ValidationResult result = isEmailValid()
      .and(isPhoneNumberValid())
      .and(isAnAdult())
      .apply(customer);
    System.out.println(result);

    if (result != ValidationResult.SUCCESS) throw new IllegalStateException(
      result.name()
    );
  }
}
