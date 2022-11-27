using System.Text.RegularExpressions;

public class Ej13
{
  public static void main()
  {
    Console.WriteLine(DecimalDigitInformation("The 7 is the digit!"));    // Digit 7 at position 4
    Console.WriteLine(DecimalDigitInformation("Hamster and lion"));       // No digit found!
    Console.WriteLine(DecimalDigitInformation("1st"));                    // Digit 1 at position 0
  }

  static string DecimalDigitInformation(string word)
  {
    Regex regex = new Regex(@"\d");
    Match match = regex.Match(word);

    return match.Success ? $"Digit {match.Value} at position {match.Index}" : $"No digit found!";
  }
}