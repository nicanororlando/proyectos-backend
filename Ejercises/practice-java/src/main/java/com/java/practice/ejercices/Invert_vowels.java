package com.java.practice.ejercices;

import java.util.*;

public class Invert_vowels {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String S = in.nextLine();
    List<String> vowels = new ArrayList<>();

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == 'a') vowels.add("a");
      if (S.charAt(i) == 'e') vowels.add("e");
      if (S.charAt(i) == 'i') vowels.add("i");
      if (S.charAt(i) == 'o') vowels.add("o");
      if (S.charAt(i) == 'u') vowels.add("u");
    }

    for (int i = (S.length() - 1); i >= 0; i--) {
      if (
        S.charAt(i) == 'a' ||
        S.charAt(i) == 'e' ||
        S.charAt(i) == 'i' ||
        S.charAt(i) == 'o' ||
        S.charAt(i) == 'u'
      ) {
        S = replace(S, i, vowels.get(0));
        vowels.remove(0);
      }
    }
    in.close();

    System.out.println(S);
  }

  static String replace(String str, int index, String replace) {
    if (str == null) {
      return str;
    } else if (index < 0 || index >= str.length()) {
      return str;
    }
    char[] chars = str.toCharArray();
    chars[index] = replace.charAt(0);
    return String.valueOf(chars);
  }
}
