package com.java.practice.ejercices;

import java.util.*;

public class ej13 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    sc.close();

    for (int i = 0; i < (Math.floor(A.length() / 2)); i++) {
      if (
        A
          .substring(i, i + 1)
          .compareTo(A.substring((A.length() - (i + 1)), A.length() - (i))) !=
        0
      ) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}
