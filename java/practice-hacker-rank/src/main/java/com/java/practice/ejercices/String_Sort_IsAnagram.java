package com.java.practice.ejercices;

import java.util.Arrays;
import java.util.Scanner;

// We have to check if the two strings are Anagrams or not.

public class String_Sort_IsAnagram {

  static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false; else {
      a = a.toLowerCase();
      b = b.toLowerCase();
      char[] c1 = a.toCharArray();
      char[] c2 = b.toCharArray();
      Arrays.sort(c1);
      Arrays.sort(c2);
      String sc1 = new String(c1);
      String sc2 = new String(c2);

      return sc1.equals(sc2);
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // String a = scan.next();
    // String b = scan.next();

    String a = "anagram";
    String b = "margana";

    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println((ret) ? "Anagrams" : "Not Anagrams");
  }
}
