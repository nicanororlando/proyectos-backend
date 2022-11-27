package com.java.practice.ejercices;

import java.util.Scanner;

public class ej5 {

  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      try {
        long x = sc.nextLong();
        System.out.println(x + " can be fitted in:");
        if (x >= -128 && x <= 127) System.out.println(
          "* byte \n* short \n* int \n* long"
        ); else if (x >= -32768 && x <= 32767) System.out.println(
          "* short \n* int \n* long"
        ); else if (
          x > -(Math.pow(2, 31)) && x < (Math.pow(2, 31))
        ) System.out.println("* int \n* long"); else if (
          x > -(Math.pow(2, 63)) && x < (Math.pow(2, 63))
        ) System.out.println("* long"); else throw new Exception();
      } catch (Exception e) {
        System.out.println(sc.next() + " can't be fitted anywhere.");
      }
    }
    sc.close();
  }
}
