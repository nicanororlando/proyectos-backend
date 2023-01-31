namespace c.sharp
{
  class UserInput
  {

    public UserInput() { }

    public void swapNumbers()
    {
      Console.WriteLine("Please enter the first number: ");
      string number1Input = Console.ReadLine();
      Console.WriteLine("Please enter the second number: ");
      string number2Input = Console.ReadLine();

      int num1 = int.Parse(number1Input);
      int num2 = int.Parse(number2Input);

      Console.WriteLine("Firstyle a is: " + num1 + " and b is: " + num1);

      int temp = num1;
      num1 = num2;
      num2 = temp;

      Console.WriteLine("Finally after the swap, a is: " + num1 + " and b is: " + num1);
    }
  }
}