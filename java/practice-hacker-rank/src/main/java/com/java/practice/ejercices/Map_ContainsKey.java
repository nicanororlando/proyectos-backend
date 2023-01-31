package com.java.practice.ejercices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
public class Map_ContainsKey {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    Map<String, String> names = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String name = in.nextLine();
      String phone = in.nextLine();

      names.put(name, phone);
    }
    while (in.hasNext()) {
      String s = in.nextLine();
      if (names.containsKey(s)) System.out.println(
        s + "=" + names.get(s)
      ); else System.out.println("Not found");
    }
    in.close();
  }
}
