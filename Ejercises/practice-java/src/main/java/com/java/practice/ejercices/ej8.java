package com.java.practice.ejercices;

import java.util.Scanner;

public class ej8 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Integer n = scanner.nextInt();
    scanner.close();

    if (n >= -100 && n <= 100) {
      String s = n.toString();
      if (s.isEmpty()) System.out.println(
        "Wrong answer"
      ); else System.out.println("Good job");
    }
  }
}
