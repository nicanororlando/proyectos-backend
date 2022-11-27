package com.java.practice.ejercices;

import java.util.Scanner;

public class Regex_IP_Pattern {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      String IP = in.next();

      // Return true if the IP matches with our own pattern.
      System.out.println(IP.matches(new MyRegex().pattern));
    }
    in.close();
  }
}

/*
     [01]?\\d{1,2}   matches numbers 0-199.
     2[0-4]\\d       matches numbers 200-249
     25[0-5]         matches numbers 250-255
*/
class MyRegex {

  String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
  String pattern = num + "." + num + "." + num + "." + num;
}
// class MyRegex {
//   String ip0to255 = "(\\d{1,2}||(0|1)\\d{2}||2[0-4]\\d||25[0-5])";
//   public String pattern =
//     ip0to255 + "\\." + ip0to255 + "\\." + ip0to255 + "\\." + ip0to255;
// }
