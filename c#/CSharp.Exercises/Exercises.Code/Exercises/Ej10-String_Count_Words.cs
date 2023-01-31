public class Ej10
{
  public static void main()
  {
    Console.WriteLine(NumberOfWords_method2("Mauris consectetur urna sit amet risus ultricies rutrum.")); // 8
    Console.WriteLine(NumberOfWords_method2("Quisque M"));                                                // 2
    Console.WriteLine(NumberOfWords_method2("Xor"));
  }

  static int NumberOfWords_method1(string str)
  {
    int numberOfWords = 0;
    for (int i = 0; i < str.Length; i++)
    {
      numberOfWords = (char.IsWhiteSpace(str[i]) ? numberOfWords + 1 : numberOfWords);
    }
    return numberOfWords + 1;
  }

  static int NumberOfWords_method2(string str)
  {
    return str.Split(" ").Length;
  }
}