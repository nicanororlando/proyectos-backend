package com.java.practice.ejercices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Read_Mat_Funcional {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );

    List<List<Integer>> arr = new ArrayList<>();

    IntStream
      .range(0, 6) // for(int i=0;i<6;i++)
      .forEach(i -> {
        try {
          arr.add(
            Stream
              .of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
              .map(Integer::parseInt)
              .collect(Collectors.toList())
          );
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      });

    arr.stream().forEach(System.out::print);

    bufferedReader.close();
  }
}
// 1 2 2 3 4 5
// 1 3 5 3 5 3
// 1 2 2 3 4 5
// 1 3 5 3 5 3
// 1 2 2 3 4 5
// 1 3 5 3 5 3
// 1 2 2 3 4 5
// 1 3 5 3 5 3
// 1 2 2 3 4 5
// 1 3 5 3 5 3
