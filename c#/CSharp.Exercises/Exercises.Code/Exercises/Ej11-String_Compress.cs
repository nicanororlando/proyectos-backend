public class Ej11
{
  public static void main()
  {
    Console.WriteLine(CompressString("aaaabbcccccdaa"));    //a4b2c5d1a2
    Console.WriteLine(CompressString("948kro"));            //914181k1r1o1
    Console.WriteLine(CompressString("$999j*#jjjfYyyy"));   //$193j1*1#1j3f1Y1y3
  }

  static string CompressString(string str)
  {
    var count = 0;
    var last = str[0];
    var newString = string.Empty;

    foreach (var s in str)
    {
      if (s == last) count++;
      else
      {
        // Al no haber coincidencia en el string, lo agrego añadiendole la cantidad que habia anteriormente.
        newString += last.ToString() + count;

        // This is for the next iteration:
        count = 1;
        last = s;
      }
    }

    newString += last.ToString() + count;

    return newString;
  }
}