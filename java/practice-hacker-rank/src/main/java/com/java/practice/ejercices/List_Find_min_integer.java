package com.java.practice.ejercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class List_Find_min_integer {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt(); // The numbers of paths the train can take
    List<Integer> myIntArray = Arrays.asList((int) Double.POSITIVE_INFINITY, 0);

    for (int i = 0; i < N; i++) {
      int Q = in.nextInt(); // The number of persons on the path
      int V = in.nextInt(); // The individual value of each person on the path

      if (myIntArray.get(0) > Q) {
        myIntArray.set(0, Q);
        myIntArray.set(1, V);
      }
      System.out.println(myIntArray.get(1));
    }
    in.close();

    System.out.println(myIntArray.get(1));
  }
}
