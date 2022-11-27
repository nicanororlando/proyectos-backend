package com.java.practice.ejercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ej6 {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scanner = new Scanner(System.in);
    List<String> inputString = new ArrayList<>();

    while (scanner.hasNext()) {
      inputString.add(scanner.nextLine());
    }
    scanner.close();

    for (int i = 0; i < inputString.size(); i++) {
      System.out.println(i + 1 + " " + inputString.get(i));
    }
  }
}
