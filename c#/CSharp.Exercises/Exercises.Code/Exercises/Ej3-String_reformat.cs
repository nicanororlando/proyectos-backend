public class Ej3
{
  public Ej3() { }
  public void main()
  {
    var logLine = new LogLine();

    Console.WriteLine(logLine.Message("[ERROR]: Stack overflow"));    // --> Stack overflow
    Console.WriteLine(logLine.LogLevel("[ERROR]: Stack overflow"));   // --> error
    Console.WriteLine(logLine.Reformat("[ERROR]: Stack overflow"));   // --> Stack overflow (error)
  }
}

// Trim, substring and more:
// https://learn.microsoft.com/en-us/dotnet/csharp/how-to/search-strings#where-does-the-sought-text-occur-in-a-string
// https://learn.microsoft.com/en-us/dotnet/csharp/how-to/search-strings#where-does-the-sought-text-occur-in-a-string
// https://learn.microsoft.com/en-us/dotnet/csharp/how-to/modify-string-contents#trim-white-space

public class LogLine
{
  public string Message(string logLine)
  {
    int first = logLine.IndexOf(":") + 1;
    return logLine.Substring(first, logLine.Length - first).Trim();
  }

  public string LogLevel(string logLine)
  {
    int first = logLine.IndexOf("[") + "[".Length;
    int last = logLine.IndexOf("]") - "]".Length;
    return logLine.Substring(first, last).ToLower();
  }

  public string Reformat(string logLine)
  {
    int firstIndexLevel = logLine.IndexOf("[") + 1;
    int lastIndexLevel = logLine.IndexOf("]") - 1;
    string level = logLine.Substring(firstIndexLevel, lastIndexLevel).ToLower();

    int firstIndexMsg = logLine.IndexOf(":") + 1;
    string message = logLine.Substring(firstIndexMsg, logLine.Length - firstIndexMsg).Trim();

    return message + " (" + level + ")";
  }
}