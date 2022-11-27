public class Ej21
{
  public static void main()
  {
    var array = new int[][] {new int[]{ 1, 2, 3, 4, 5 },
                                     new int[]{ 6, 7, 8, 9, 10 },
                                     new int[]{ 11, 12, 13, 14, 15 },
                                     new int[]{ 16, 17, 18, 19, 20 },
                                     new int[]{ 21, 22, 23, 24, 25 }};

    var transposedArray = Enumerable.Range(0, array.Length).Select(x => array.Select(y => y[x]));

    foreach (var row in transposedArray)
    {
      foreach (var number in row)
      {
        Console.Write(number + " ");
      }
      Console.WriteLine();
    }
    //1 6 11 16 21
    //2 7 12 17 22
    //3 8 13 18 23
    //4 9 14 19 24
    //5 10 15 20 25
  }
}