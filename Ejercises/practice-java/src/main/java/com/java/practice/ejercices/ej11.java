package com.java.practice.ejercices;

import java.util.Scanner;

/* Given two strings we have to:
 * 1. Sum the lengths of the strings.
 * 2. Determine if A > B.
 * 3. Capitalize the first letter in A and B, and print both in a single line.
 */

public class ej11 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    String B = sc.next();
    sc.close();

    System.out.println(A.length() + B.length());
    if (A.compareTo(B) < 0) System.out.println("No"); else if (
      A.compareTo(B) > 0
    ) System.out.println("Yes"); else System.out.println("Equal");

    String a = A.substring(0, 1).toUpperCase() + A.substring(1);
    String b = B.substring(0, 1).toUpperCase() + B.substring(1);
    System.out.println(a + " " + b);
  }
}
