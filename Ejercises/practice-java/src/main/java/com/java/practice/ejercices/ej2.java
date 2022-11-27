package com.java.practice.ejercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Given this input:
 * java 100
 * cpp 65
 * python 50
 *
 * We have to return:
 * ================================
 * java           100
 * cpp            065
 * python         050
 * ================================
 */

public class ej2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> stringArray = new ArrayList<>();
    List<Integer> intArray = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      stringArray.add(scanner.next());
      intArray.add(scanner.nextInt());
    }
    scanner.close();

    System.out.println("================================");
    for (int i = 0; i < 3; i++) {
      System.out.printf("%-14s %03d\n", stringArray.get(i), intArray.get(i));
    }
    System.out.println("================================");
  }
}
// INPUT:
// java 100
// cpp 65
// python 50
