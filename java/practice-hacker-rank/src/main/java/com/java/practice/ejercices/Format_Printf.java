package com.java.practice.ejercices;

import java.util.Scanner;

/* Calculate the area of a Square. */

public class Format_Printf {

  public static void main(String[] args) throws Exception {
    double height;
    double breadth;

    Scanner scanner = new Scanner(System.in);
    System.out.println("How many areas do you want to calculate?");
    int N = scanner.nextInt();

    for (int i = 0; i < N; i++) {
      System.out.println("Height: \t");
      height = scanner.nextDouble();
      System.out.println("Breadth: \t");
      breadth = scanner.nextDouble();

      if (breadth <= 0 || height <= 0) throw new Exception(
        "Breadth and height must be positive"
      ); else System.out.printf(
        "The area calculated is: %.0f \n",
        breadth * height
      );

      if (i == N - 1) scanner.close();
    }
  }
}
