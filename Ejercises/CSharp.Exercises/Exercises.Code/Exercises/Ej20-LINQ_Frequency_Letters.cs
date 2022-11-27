public class Ej20
{
  public static void main()
  {
    string word = "abracadabra";

    var letters = word.GroupBy(x => x);

    foreach (var l in letters)
    {
      Console.Write($"Letter {l.Key} occurs {l.Count()} time(s), ");
      // Letter a occurs 5 time(s), Letter b occurs 2 time(s), Letter r occurs 2 time(s)
      // Letter r occurs 2 time(s), Letter c occurs 1 time(s), Letter d occurs 1 time(s)
    }
  }
}