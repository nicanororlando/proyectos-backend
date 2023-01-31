using System.Text.RegularExpressions;

public class Ej14
{
  public static void main()
  {
    Console.WriteLine(ReplaceGoodWithBad("Very GoOd"));         // Very bad
    Console.WriteLine(ReplaceGoodWithBad("GooDgOOdGOODgood"));  // badbadbadbad
    Console.WriteLine(ReplaceGoodWithBad("Not so g00d"));       // Not so g00d
  }

  static string ReplaceGoodWithBad(string word)
  {
    string output = string.Empty;
    return output = Regex.Replace(word, @"((G|g)(O|o){2}(D|d))", "bad");
  }
}