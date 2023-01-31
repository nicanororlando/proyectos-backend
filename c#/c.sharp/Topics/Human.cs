namespace c.sharp
{
  public class Human
  {
    private string name = "Canor";

    public Human() { }

    ~Human()
    {
      // This is the finalizer, included if we need to do something in the end of the class.
      Console.WriteLine("Human deconstructor...");
    }

    public string Name
    {
      get { return name; }
      set { name = value; }
    }
    // public void setName(string name)
    // {
    //   this.name = name;
    // }

    // public string getName()
    // {
    //   return this.name;
    // }
  }
}
