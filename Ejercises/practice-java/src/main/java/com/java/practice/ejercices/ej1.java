package com.java.practice.ejercices;

import java.util.Scanner;

/* Given this input (stdin):

 * 42
 * 3.1415
 * Welcome to HackerRank's Java tutorials!
 *
 * 
 * I have to return in output (stdout):
 * 
 * String: Welcome to HackerRank's Java tutorials!
 * Double: 3.1415
 * Int: 42
 */

public class ej1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int i = scan.nextInt();
    Double d = scan.nextDouble();
    String s = scan.nextLine();

    while (scan.hasNext()) {
      String nextLine = scan.nextLine();
      s += nextLine;
      if (s.contains(".")) {
        break;
      }
    }
    scan.close();

    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
  }
}
// INPUT;
// 42
// 3.1415
// Welcome to HackerRank's Java tutorials.
