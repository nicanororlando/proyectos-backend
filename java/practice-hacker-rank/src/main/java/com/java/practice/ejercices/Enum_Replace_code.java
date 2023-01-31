package com.java.practice.ejercices;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Enum_Replace_code {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (in.hasNextLine()) {
      in.nextLine();
    }
    for (int i = 0; i < n; i++) {
      String line = in.nextLine();

      if (line.contains(Element.EQUALS.label)) line =
        line.replaceAll(Element.EQUALS.label, ElementChanged.EQUALS.label);
      if (line.contains(Element.MAYBE_EQUALS.label)) line =
        line.replaceAll(
          Element.MAYBE_EQUALS.label,
          ElementChanged.MAYBE_EQUALS.label
        );
      if (line.contains(Element.PROBABLY_EQUALS.label)) line =
        line.replaceAll(
          Element.PROBABLY_EQUALS.label,
          ElementChanged.PROBABLY_EQUALS.label
        );
      if (line.contains(Element.LISTEN_UP.label)) line =
        line.replaceAll(
          Element.LISTEN_UP.label,
          ElementChanged.LISTEN_UP.label
        );
      if (line.contains(Element.MINUS.label)) line =
        line.replaceAll(Element.MINUS.label, ElementChanged.MINUS.label);
      if (line.contains(Element.PLUS.label)) line =
        line.replaceAll(Element.PLUS.label, ElementChanged.PLUS.label);
      if (line.contains(Element.TIMES.label)) line =
        line.replaceAll(Element.TIMES.label, ElementChanged.TIMES.label);
      if (line.contains(Element.SLASH.label)) line =
        line.replaceAll(Element.SLASH.label, ElementChanged.SLASH.label);
      if (line.contains(Element.YOUSEEEEEE.label)) line =
        line.replaceAll(
          Element.YOUSEEEEEE.label,
          ElementChanged.YOUSEEEEEE.label
        );

      System.out.println(line);
    }
    in.close();
  }

  enum Element {
    EQUALS("equals"),
    MAYBE_EQUALS("maybeEquals"),
    PROBABLY_EQUALS("probablyEquals"),
    LISTEN_UP("listenUp"),
    MINUS("-"),
    PLUS("+"),
    TIMES("*"),
    SLASH("/"),
    YOUSEEEEEE("YOUSEEEEEE?");

    public final String label;

    public String getAction() {
      return this.label;
    }

    private Element(String label) {
      this.label = label;
    }
  }

  enum ElementChanged {
    EQUALS("="),
    MAYBE_EQUALS("=="),
    PROBABLY_EQUALS("==="),
    LISTEN_UP("!"),
    MINUS("+"),
    PLUS("-"),
    TIMES("times"),
    SLASH("slash"),
    YOUSEEEEEE(";");

    public final String label;

    public String getAction() {
      return this.label;
    }

    private ElementChanged(String label) {
      this.label = label;
    }
  }
}
