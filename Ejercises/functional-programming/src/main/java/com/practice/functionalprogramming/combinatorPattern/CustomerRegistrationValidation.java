package com.practice.functionalprogramming.combinatorPattern;

import static com.practice.functionalprogramming.combinatorPattern.CustomerRegistrationValidation.*;
import static com.practice.functionalprogramming.combinatorPattern.CustomerRegistrationValidation.ValidationResult.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

// En la clase que implemente esta interface, NO puedo crear objetos.
public interface CustomerRegistrationValidation
  extends Function<Customer, ValidationResult> {
  /*
   * Para hacer uso de estos metodos no hace falta crear una instancia de esta clase. Entonces como en una interfaz
   * no se pueden crear objetos, se puede acceder a los metodos sin instanciar gracias al modificador static.
   */
  static CustomerRegistrationValidation isEmailValid() {
    return customer ->
      customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
  }

  static CustomerRegistrationValidation isPhoneNumberValid() {
    return customer ->
      customer.getPhoneNumber().contains("+0")
        ? SUCCESS
        : PHONE_NUMBER_NOT_VALID;
  }

  static CustomerRegistrationValidation isAnAdult() {
    return customer ->
      Period.between(customer.getDob(), LocalDate.now()).getYears() > 16
        ? SUCCESS
        : IS_NOT_AN_ADULT;
  }

  default CustomerRegistrationValidation and(
    CustomerRegistrationValidation other
  ) {
    return customer -> {
      ValidationResult result = this.apply(customer);
      return result.equals(SUCCESS) ? other.apply(customer) : result;
    };
  }

  enum ValidationResult {
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT,
  }
}
