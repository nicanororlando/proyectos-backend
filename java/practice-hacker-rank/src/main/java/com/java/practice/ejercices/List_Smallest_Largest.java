package com.java.practice.ejercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List_Smallest_Largest {

  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";

    List<String> array = new ArrayList<>();

    for (int i = 0; i < s.length() - (k - 1); i++) {
      array.add(s.substring(i, i + k));
    }

    if (s.length() == k) {
      smallest = s;
      largest = s;
    } else {
      for (int i = 0; i < s.length() - (k - 1); i++) {
        for (int j = i + 1; j < s.length() - (k - 1); j++) {
          if (j == 1) {
            if (array.get(i).compareTo(array.get(j)) < 0) {
              smallest = array.get(i);
              largest = array.get(j);
            } else {
              smallest = array.get(j);
              largest = array.get(i);
            }
          } else {
            if (array.get(j).compareTo(smallest) < 0) smallest = array.get(j);
            if (array.get(j).compareTo(largest) > 0) largest = array.get(j);
          }
        }
      }
    }

    return smallest + "\n" + largest;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }
}
