package com.practice.functionalprogramming.optionals;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    Object nullValue = Optional
      .ofNullable(null)
      .orElseGet(() -> "Default value");

    Object value = Optional
      .ofNullable("Hello")
      .orElseGet(() -> "Default value");

    System.out.println(nullValue);
    System.out.println(value);

    // Object valueException = Optional
    //   .ofNullable(null)
    //   .orElseThrow(() -> new IllegalStateException("exception"));

    Optional
      .ofNullable("nicanororlando@gmail.com")
      .ifPresent(email -> System.out.println("Sending email to " + email));

    Optional
      .ofNullable(null)
      .ifPresentOrElse(
        email -> System.out.println("Sending email to " + email),
        () -> System.out.println("Cannot send email")
      );
  }
}
