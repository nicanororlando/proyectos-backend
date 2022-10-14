package com.java.practice.ejercices;

import java.io.*;
import java.text.*;
import java.util.*;

class Result {

  /*
   * Complete the 'findDay' function below.
   *
   * The function is expected to return a STRING with the day name.
   * The function accepts following parameters:
   *  1. INTEGER month
   *  2. INTEGER day
   *  3. INTEGER year
   */

  public static String findDay(int month, int day, int year)
    throws ParseException {
    String inputDateStr = String.format("%s/%s/%s", day, month, year);
    Date inputDate = null;

    inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(inputDate);

    String dayOfWeek = calendar
      .getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)
      .toUpperCase();

    return dayOfWeek;
  }
}

public class ej9 {

  public static void main(String[] args) throws IOException, ParseException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    BufferedWriter bufferedWriter = new BufferedWriter(
      new FileWriter(System.getenv("OUTPUT_PATH"))
    );

    String[] firstMultipleInput = bufferedReader
      .readLine()
      .replaceAll("\\s+$", "")
      .split(" ");

    int month = Integer.parseInt(firstMultipleInput[0]);

    int day = Integer.parseInt(firstMultipleInput[1]);

    int year = Integer.parseInt(firstMultipleInput[2]);

    String res = Result.findDay(month, day, year);

    bufferedWriter.write(res);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
