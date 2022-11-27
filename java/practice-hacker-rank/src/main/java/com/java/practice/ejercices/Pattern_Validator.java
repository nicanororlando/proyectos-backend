package com.java.practice.ejercices;

import java.util.Scanner;
import java.util.regex.Pattern;

/* Given this patterns, we must validate:
 * 3
 *
 * ([A-Z])(.+)
 * [AZ[a-z](a-z)
 * batcatpat(nat
 *
 * Expected output:
 * Valid
 * Invalid
 * Invalid
 */

public class Pattern_Validator {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String pattern = in.nextLine();

      try {
        Pattern.compile(pattern);
        System.out.println("Valid");
      } catch (Throwable t) {
        System.out.println("Invalid");
      }
      testCases--;
    }
    in.close();
  }
}
