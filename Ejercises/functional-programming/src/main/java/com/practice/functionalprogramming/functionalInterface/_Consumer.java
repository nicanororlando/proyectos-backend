package com.practice.functionalprogramming.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Its a void function
public class _Consumer {

  public static void main(String[] args) {
    Customer customer = new Customer("Canor", 12345678);

    // Normal java function
    greetCustomer(customer);
    greetCustomerV2(customer, false);

    // Functional interface
    greetCustomerConsumer.accept(customer);
    greetCustomerConsumerV2.accept(customer, false);
  }

  // We can said that 'Consumer' is like a void function who takes one argument.
  static Consumer<Customer> greetCustomerConsumer = customer ->
    System.out.println(
      "Hello " +
      customer.customerName +
      ", thanks for registering phone number " +
      customer.customerPhoneNumber
    );

  static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
    System.out.println(
      "Hello " +
      customer.customerName +
      ", thanks for registering phone number " +
      (showPhoneNumber ? customer.customerPhoneNumber : "********")
    );

  // Normal form:
  static void greetCustomer(Customer customer) {
    System.out.println(
      "Hello " +
      customer.customerName +
      ", thanks for registering phone number " +
      customer.customerPhoneNumber
    );
  }

  static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
    System.out.println(
      "Hello " +
      customer.customerName +
      ", thanks for registering phone number " +
      (showPhoneNumber ? customer.customerPhoneNumber : "********")
    );
  }

  static class Customer {

    private final String customerName;
    private final Integer customerPhoneNumber;

    Customer(String customerName, Integer customerPhoneNumber) {
      this.customerName = customerName;
      this.customerPhoneNumber = customerPhoneNumber;
    }
  }
}
