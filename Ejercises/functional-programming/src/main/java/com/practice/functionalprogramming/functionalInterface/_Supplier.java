package com.practice.functionalprogramming.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

// Is like a Getter function
public class _Supplier {

  public static void main(String[] args) {
    System.out.println(getDBConnectionUrl());
    System.out.println(getDBConnectionUrlSupplier.get());
    System.out.println(getDBConnectionsUrlSupplier.get());
  }

  // Functional form:
  static Supplier<String> getDBConnectionUrlSupplier = () ->
    "jdbc://localhost:5432/users";

  static Supplier<List<String>> getDBConnectionsUrlSupplier = () ->
    List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/customers");

  // Normal form:
  static String getDBConnectionUrl() {
    return "jdbc://localhost:5432/users";
  }
}