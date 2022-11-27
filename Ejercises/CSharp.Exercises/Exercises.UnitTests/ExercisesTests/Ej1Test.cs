namespace Exercises.UnitTests;

using CSharp.Exercises.Code.Code.Exercises;

public class Ej1Test
{
  [Fact]
  public void ExpectedMinutesInOven__Returns_40()
  {
    Assert.Equal(40, new Lasagna().ExpectedMinutesInOven());
  }

  [Fact]
  public void RemainingMinutesInOven__Returns_10()
  {
    Assert.Equal(10, new Lasagna().RemainingMinutesInOven(30));
  }

  [Fact]
  public void PreparationTimeInMinutes__Returns_4()
  {
    Assert.Equal(4, new Lasagna().PreparationTimeInMinutes(2));
  }

  [Fact]
  public void ElapsedTimeInMinutes__Returns_26()
  {
    Assert.Equal(26, new Lasagna().ElapsedTimeInMinutes(3, 20));
  }
}