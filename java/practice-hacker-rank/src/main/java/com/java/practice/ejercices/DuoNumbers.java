package com.java.practice.ejercices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuoNumbers {

  public static void main(String[] args) {
    System.out.println(isDuoDigit(12));
    System.out.println(isDuoDigit(110));
    System.out.println(isDuoDigit(102));
    System.out.println(isDuoDigit(-2021));
  }

  public static String isDuoDigit(int number) {
    Set<Character> set = new HashSet<>();

    String numberStr = String.valueOf(number);

    for (int i = 0; i < numberStr.length(); i++) {
      set.add(numberStr.charAt(i));
    }
    return set.size() <= 2 ? "y" : "n";
  }

  static String isDuoDigitV2(int number) {
    // If the number is negative.
    String s = String.valueOf(number).replace("-", "");

    Map<Integer, Integer> map = new HashMap<>();

    for (int j = 0; j < s.length(); j++) {
      // map.merge((int) s.charAt(j), 1, Integer::sum);
      map.merge((int) s.charAt(j), 1, (a, b) -> a + b);
    }

    long count = map.values().size();
    return count <= 2 ? "y" : "n";
  }
}
