public class Ej7
{
  public static void main()
  {
    string input = "qwerty";
    Console.WriteLine($"Input: {input} | Output --> {StringInReverseOrder(input)}");
  }

  static string StringInReverseOrder(string input)
  {
    string output = string.Empty;
    for (int i = input.Length - 1; i >= 0; i--)
    {
      output += input[i];
    }

    return output;
  }
}