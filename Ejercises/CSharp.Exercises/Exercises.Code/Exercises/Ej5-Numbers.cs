public class Ej5
{
  public void main()
  {
    Console.WriteLine($"Expected: 0.77 --> {SuccessRate(10)}");
    Console.WriteLine($"Expected: 1193.4 --> {ProductionRatePerHour(6)}");
    Console.WriteLine($"Expected: 19 --> {WorkingItemsPerMinute(6)}");
  }
  static double SuccessRate(int speed)
  {
    if (speed >= 1 && speed <= 4) return 1.0;
    else if (speed >= 5 && speed <= 8) return 0.9;
    else if (speed == 9) return 0.8;
    else if (speed == 10) return 0.77;
    return 0;
  }

  static double ProductionRatePerHour(int speed)
  {
    if (speed >= 1 && speed <= 4) return 1 * 221 * speed;
    else if (speed >= 5 && speed <= 8) return 0.9 * 221 * speed;
    else if (speed == 9) return 0.8 * 221 * speed;
    else if (speed == 10) return 0.77 * 221 * speed;
    return 0;
  }

  static int WorkingItemsPerMinute(int speed)
  {
    if (speed >= 1 && speed <= 4) return (int)(Math.Floor(3.68 * speed));
    else if (speed >= 5 && speed <= 8) return (int)(Math.Floor(0.9 * 3.68 * speed));
    else if (speed == 9) return (int)(Math.Floor(0.8 * 3.68 * speed));
    else if (speed == 10) return (int)(Math.Floor(0.77 * 3.68 * speed));
    return 0;
  }
}