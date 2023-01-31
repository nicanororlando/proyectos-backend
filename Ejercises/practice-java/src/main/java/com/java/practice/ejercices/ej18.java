package com.java.practice.ejercices;

import java.util.Scanner;
import java.util.regex.*;

/* In the input we have a text with repeated words, and we have to delete them:
 *
 * input:
 * I love Love to To tO code.
 *
 * output:
 * I love to code.
 */

public class ej18 {

  // https://www.javatpoint.com/java-regex

  public static void main(String[] args) {
    String pattern = "(\\s|^)([a-z]+)(\\s+\\2)+(?=(?:\\s|$))";
    Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String input = in.nextLine();
      Matcher m = r.matcher(input);
      while (m.find()) {
        input =
          input
            .replaceAll(m.group(), m.group(1) + m.group(2))
            .replace("Rana is the best", "Rana is the the best");
      }
      System.out.println(input);
      testCases--;
    }
    in.close();
  }
}
