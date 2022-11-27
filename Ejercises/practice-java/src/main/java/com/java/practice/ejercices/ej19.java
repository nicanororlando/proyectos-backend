package com.java.practice.ejercices;

import java.util.Scanner;

/* Username validator:
  The username consists of 8 to 30 characters inclusive. If the username consists of less than 8 or greater than 30
characters, then it is an invalid username. 
  The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the 
character set consisting of lowercase characters [a-z], uppercase characters [A-Z], and digits [0-9].
  The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or 
uppercase character [A-Z]. */

class UsernameValidator {

  public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
}

public class ej19 {

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int n = Integer.parseInt(scan.nextLine());
    while (n-- != 0) {
      String userName = scan.nextLine();

      if (userName.matches(UsernameValidator.regularExpression)) {
        System.out.println("Valid");
      } else {
        System.out.println("Invalid");
      }
    }
  }
}
