public class Ej8
{
  public static void main()
  {
    Console.WriteLine(SortCharactersDescending("Aliquam pulvinar aliquam libero, in fringilla erat.")); // vuuutrrrrqqponnnmmlllllliiiiiiigfeebaaaaaaA.,            
    Console.WriteLine(SortCharactersDescending("Thi2 12  5@mpl3 Str!nG~"));
  }

  static char[] SortCharactersDescending(string str)
  {
    char[] charArray = str.ToCharArray();
    char ch;

    for (int i = 1; i < str.Length; i++)
    {
      for (int j = 0; j < str.Length - 1; j++)
      {
        if (charArray[j] > charArray[j + 1])
        {
          ch = charArray[j];
          charArray[j] = charArray[j + 1];
          charArray[j + 1] = ch;
        }
      }
    }

    return charArray;
  }
}

