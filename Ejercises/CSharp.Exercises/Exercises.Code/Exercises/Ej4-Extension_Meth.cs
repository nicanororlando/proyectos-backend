// EXTENSION METHODS:
// https://learn.microsoft.com/en-us/dotnet/csharp/programming-guide/classes-and-structs/extension-methods
// https://csharp.net-tutorials.com/data-types/strings/

public class Ej4
{
  public void main()
  {

    var log = "[INFO]: File Deleted.";
    Console.WriteLine(log.SubstringAfter(": "));        // => returns "File Deleted."
    Console.WriteLine("FIND >>> SOMETHING <===< HERE".SubstringBetween(">>> ", " <===<"));  // => returns "INFO");

    var log2 = "[ERROR]: Missing ; on line 20.";
    Console.WriteLine(log2.Message());  // => returns "Missing ; on line 20.");
    Console.WriteLine(log2.LogLevel());  // => returns "ERROR);

  }
}

// Al ser un metodo de extension debe definirse de forma estatica.
public static class LogAnalysis
{
  public static string SubstringAfter(this string log, string symbol)
  {
    int first = log.IndexOf(symbol) + symbol.Length;
    return log.Substring(first, log.Length - first);
  }

  public static string SubstringBetween(this string log, string symbol1, string symbol2)
  {
    int first = log.IndexOf(symbol1) + (symbol1.Length);
    int last = log.LastIndexOf(symbol2);

    // Substring(startIndex, Length)
    return log.Substring(first, (last - first)).ToUpper().Trim();
  }

  public static string Message(this string log)
  {
    int first = log.IndexOf(":") + 1;
    return log.Substring(first, log.Length - first).Trim();
  }

  public static string LogLevel(this string log)
  {
    int first = log.IndexOf("[") + 1;
    int last = log.IndexOf("]") - 1;
    return log.Substring(first, last).ToUpper();
  }
}