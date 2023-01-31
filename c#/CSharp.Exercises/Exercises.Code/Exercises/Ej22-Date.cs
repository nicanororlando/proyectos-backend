public class Ej22
{
  public static void main()
  {
    Console.WriteLine(HowManyDays(new DateTime(2005, 12, 8), DateTime.Now)); //4706
  }

  static int HowManyDays(DateTime dateInThePast, DateTime dateNow)
  {
    return (dateNow - dateInThePast).Days;
  }
}