package main.java.com.java.practice.ejercices;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (in.hasNextLine()) {
      in.nextLine();
    }
    for (int i = 0; i < n; i++) {
      String line = in.nextLine();
      System.out.println(Element.EQUALS);
    }
  }

  enum Element {
    EQUALS("equals"),
    MAYBE_EQUALS("maybeEquals"),
    PROBABLY_EQUALS("probablyEquals"),
    LISTEN_UP("listenUp"),
    MINUS("-"),
    PULS("+"),
    TIMES("*"),
    SLASH("/"),
    YOUSEEEEEE("YOUSEEEEEE?");

    public String label;

    public String getAction() {
      return this.label;
    }

    private Element(String label) {
      this.label = label;
    }
  }
}
