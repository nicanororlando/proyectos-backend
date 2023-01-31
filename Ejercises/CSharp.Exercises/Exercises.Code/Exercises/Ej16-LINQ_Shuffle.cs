public class Ej16
{
  public static void main()
  {
    var rnd = new Random();
    var array = new[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    var shuffledArray = array.OrderBy(i => rnd.Next());
    foreach (var item in shuffledArray)
    {
      Console.Write(item + " "); // 4 10 3 6 2 8 1 9 7 5
    }
  }
}