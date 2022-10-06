package com.java.practice.ejercices;

import java.util.Scanner;

/* Given this input:
 * 2
 * 0 2 10
 * 5 3 5
 *
 * Return:
 * 2 6 14 30 62 126 254 510 1022 2046
 * 8 14 26 50 98
 */

public class ej4 {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int n = in.nextInt();

      double res = 0;

      for (int j = 0; j < n; j++) {
        if (j == 0) res = (a + (Math.pow(2, j)) * b); else res +=
          (Math.pow(2, j)) * b;
        System.out.printf("%.0f ", res);
      }
      System.out.println("");
    }
    in.close();
  }
}
// INPUT:
// 2
// 0 2 10
// 5 3 5
