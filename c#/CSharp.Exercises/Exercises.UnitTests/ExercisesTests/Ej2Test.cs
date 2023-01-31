namespace Exercises.UnitTests;

using CSharp.Exercises.Code.Code.Exercises;

public class Ej2Test
{
  Ej2 ej2 = new();

  [Fact]
  public void CanFastAttack__Return_False()
  {
    var knightIsAwake = true;
    Assert.False(ej2.CanFastAttack(knightIsAwake));
  }

  [Fact]
  public void CanSpy__Return_False()
  {
    var knightIsAwake = false;
    var archerIsAwake = false;
    var prisonerIsAwake = false;
    Assert.False(ej2.CanSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
  }

  [Fact]
  public void CanSignalPrisoner__Return_True()
  {
    var archerIsAwake = false;
    var prisonerIsAwake = true;
    Assert.True(ej2.CanSignalPrisoner(archerIsAwake, prisonerIsAwake));
  }

  [Fact]
  public void CanFreePrisoner__Return_True()
  {
    var knightIsAwake = false;
    var archerIsAwake = false;
    var prisonerIsAwake = true;
    var petDogIsPresent = true;
    Assert.True(ej2.CanFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
  }
}