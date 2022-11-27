package com.java.practice.ejercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Given an inline text, we have to delete spaces and symbols, and then print the array.

public class List_Split_Symbols {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    scan.close();

    List<String> symbols = new ArrayList<>(
      Arrays.asList("\\s", "\\.", "\\, ", "\\_", "\\@", "\\?", "\\'", "\\!")
    );

    String[] splited = s.split(symbols.toString());
    List<String> splitedAndRemoved = new ArrayList<>();

    for (int i = 0; i < splited.length; i++) {
      if (!splited[i].isBlank()) {
        splitedAndRemoved.add(splited[i]);
      }
    }

    System.out.println(splitedAndRemoved.size());
    for (int i = 0; i < splitedAndRemoved.size(); i++) {
      System.out.println(splitedAndRemoved.get(i));
    }
  }
}
