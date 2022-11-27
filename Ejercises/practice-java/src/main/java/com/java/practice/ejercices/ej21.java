package com.java.practice.ejercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ej21 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Integer N = scanner.nextInt();
    List<Integer> L = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      L.add(scanner.nextInt());
    }

    Integer Q = scanner.nextInt();

    for (int i = 0; i < Q; i++) {
      scanner.nextLine();
      String Qi = scanner.nextLine();

      if (Qi.equals("Insert")) {
        Integer addPosition = scanner.nextInt();
        Integer newValue = scanner.nextInt();
        L.add(addPosition, newValue);
      } else if (Qi.equals("Delete")) L.remove(scanner.nextInt());
    }

    for (int i = 0; i < L.size(); i++) {
      System.out.printf("%d ", L.get(i));
    }

    scanner.close();
  }
}
