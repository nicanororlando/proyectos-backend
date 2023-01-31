public class Ej15
{
  public static void main()
  {
    List<int> numbers = new List<int> { 6, 0, 999, 11, 443, 6, 1, 24, 54 };
    var top5 = numbers.OrderByDescending(x => x).Take(5);

    foreach (var number in top5)
    {
      Console.Write($"{number}"); // 999 443 54 24 11
    }
  }
}