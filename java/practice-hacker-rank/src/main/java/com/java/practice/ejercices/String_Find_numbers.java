package com.java.practice.ejercices;

import java.util.Scanner;

public class String_Find_numbers {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();

    int lengthStr = input.replaceAll("\\s+", "").length();
    int numbers = input.replaceAll("[^0-9]", "").length();

    int result = Math.round((lengthStr - numbers) / numbers);

    in.close();
    System.out.println(result);
  }
}
