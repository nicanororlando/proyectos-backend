public class Ej2
{
  public Ej2() { }

  public bool CanFastAttack(bool knightIsAwake)
  {
    return knightIsAwake ? false : true;
  }
  public bool CanSpy(bool knightIsAwake, bool archerIsAwake, bool prisonerIsAwake)
  {
    return (!knightIsAwake && !archerIsAwake && !prisonerIsAwake) ? false : true;
  }
  public bool CanSignalPrisoner(bool archerIsAwake, bool prisonerIsAwake)
  {
    return (!archerIsAwake && prisonerIsAwake) ? true : false;
  }
  public bool CanFreePrisoner(bool knightIsAwake, bool archerIsAwake, bool prisonerIsAwake, bool petDogIsPresent){
    if (petDogIsPresent && !archerIsAwake) return true;
    else if (!knightIsAwake && !archerIsAwake && prisonerIsAwake && !petDogIsPresent) return true;
    else return false;
  }
}