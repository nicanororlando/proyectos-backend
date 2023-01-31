public class Ej9
{
  public static void main()
  {
    Console.WriteLine(HowManyOccurrences("He is a good boy, he would never do that!", "he"));           // 1
    Console.WriteLine(HowManyOccurrences("104 593 00-930 720193", "93"));                               // 3
    Console.WriteLine(HowManyOccurrences("xyz", "a"));                                                  // 0
  }
  static int HowManyOccurrences(string str, string subStr)
  {
    int found;
    int total = 0;
    for (int i = 0; i < str.Length; i++)
    {
      // 'found' has the position of the first ocurrence of the word we are seeking for.
      found = str.IndexOf(subStr, i);

      if (found > -1)
      {
        total++;

        // For advance the path of the for loop.
        i = found;
      }
    }

    return total;
  }
}