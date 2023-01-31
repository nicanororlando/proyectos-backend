public class Ej6
{
  public static void main()
  {
    Console.WriteLine($"{Print(17, "Ryder Herbert", "Marketing")}");
    Console.WriteLine($"{Print(null, "Bogdan Rosario", "Marketing")}");
    Console.WriteLine($"{Print(59, "Julie Sokato", null)}");
    Console.WriteLine($"{Print(null, "Amare Osei", null)}");
  }

  static string Print(int? id, string name, string? department)
  {
    if (id == null && department != null) return $"{name} - {department.ToUpper()}";
    else if (id != null && department == null) return $"[{id}] - {name} - OWNER";
    else if (id == null && department == null) return $"{name} - OWNER";
    else return $"[{id}] - {name} - {department?.ToUpper()}";
  }
}
