package com.java.practice.ejercices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Given for example this input:
 * 2
 *
 * We have to return 10 lines of output iterated, and with the form:
 * 2 x i = result.
 */

public class ej3 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );

    int N = Integer.parseInt(bufferedReader.readLine().trim());

    for (int i = 1; i <= 10; i++) {
      System.out.println(N + " x " + i + " = " + (i * N));
    }

    bufferedReader.close();
  }
}
