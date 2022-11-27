package com.java.practice.ejercices;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

/* Given a specific double number, we have to format it to different locations:
 *
 * 12324.134
 *
 */

public class Format_Locale {

  static String indiaFormatedPayment(double payment) {
    Locale localeID = new Locale("in", "ID");
    String pattern = "##,##,###.###";
    NumberFormat nf = NumberFormat.getNumberInstance(localeID);
    DecimalFormat df = (DecimalFormat) nf;
    df.applyPattern(pattern);

    return df.format(payment);
  }

  public static void main(String[] args) throws ParseException {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scanner = new Scanner(System.in);

    Double payment = scanner.nextDouble();

    System.out.println(
      "US: " + NumberFormat.getInstance(Locale.US).format(payment)
    );
    System.out.println("India: Rs." + indiaFormatedPayment(payment));
    System.out.println(
      "China: " + NumberFormat.getInstance(Locale.CHINA).format(payment)
    );
    System.out.println(
      "France: " + NumberFormat.getInstance(Locale.FRANCE).format(payment)
    );

    scanner.close();
  }
}
