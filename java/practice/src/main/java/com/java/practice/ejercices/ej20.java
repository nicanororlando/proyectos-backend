package com.java.practice.ejercices;

import java.util.Scanner;
import java.util.regex.*;

public class ej20 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = Integer.parseInt(in.nextLine());

    while (t-- > 0) {
      String line = in.nextLine();

      Matcher m = Pattern.compile("<(.+)>(([^<>]+))</\\1>").matcher(line);

      if (!m.find()) {
        System.out.println("None");
        continue;
      }

      m.reset();
      while (m.find()) {
        System.out.println(m.group(2));
      }
    }
    in.close();
  }
}
