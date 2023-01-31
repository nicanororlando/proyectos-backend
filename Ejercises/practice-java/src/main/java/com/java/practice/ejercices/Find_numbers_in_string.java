package main.java.com.java.practice.ejercices;

public class Find_numbers_in_string {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();

    // Write an answer using System.out.println()
    // To debug: System.err.println("Debug messages...");

    int lengthStr = input.replaceAll("\\s+", "").length();
    int numbers = input.replaceAll("[^0-9]", "").length();

    int result = Math.round((lengthStr - numbers) / numbers);

    System.out.println(result);
  }
}
