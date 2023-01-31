public class Ej19
{
  public static void main()
  {
    string word = "THIS is UPPERCASE string LOL";

    var uppercaseOnly = word.Split(' ').Where(x => string.Equals(x, x.ToUpper()));

    foreach (var u in uppercaseOnly)
    {
      Console.Write($"{u}, "); // THIS, UPPERCASE, LOL,
    }
  }
}