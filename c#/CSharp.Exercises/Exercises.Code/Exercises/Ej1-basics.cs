namespace CSharp.Exercises.Code.Code.Exercises;

public class Ej1
{
  public Ej1() { }
  public void main()
  {
    var lasagna = new Lasagna();

    Console.WriteLine(lasagna.ExpectedMinutesInOven());      // Expected: 40
    Console.WriteLine(lasagna.RemainingMinutesInOven(30));   // Expected: 10
    Console.WriteLine(lasagna.PreparationTimeInMinutes(2));  // Expected: 4
    Console.WriteLine(lasagna.ElapsedTimeInMinutes(3, 20));  // Expected: 26
  }
}

public class Lasagna
{
  public Lasagna() { }

  private int min = 40;

  // TODO: define the 'ExpectedMinutesInOven()' method
  public int ExpectedMinutesInOven() { return 40; }

  // TODO: define the 'RemainingMinutesInOven()' method
  public int RemainingMinutesInOven(int passedMinutes) { return this.min - passedMinutes; }

  // TODO: define the 'PreparationTimeInMinutes()' method
  public int PreparationTimeInMinutes(int layers) { return layers * 2; }
  // TODO: define the 'ElapsedTimeInMinutes()' method
  public int ElapsedTimeInMinutes(int layers, int minutes)
  {
    return (layers * 2) + minutes;
  }
}