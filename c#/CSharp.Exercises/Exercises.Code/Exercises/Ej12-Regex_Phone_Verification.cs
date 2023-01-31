// https://www.geeksforgeeks.org/what-is-regular-expression-in-c-sharp/

using System.Text.RegularExpressions;

public class Ej12
{
  public static void main()
  {
    Console.WriteLine(CheckPhoneNumber("+48 592-045-990"));    // True
    Console.WriteLine(CheckPhoneNumber("+999 543-000-305"));   // False
    Console.WriteLine(CheckPhoneNumber("00 204-145-722"));     // False
    Console.WriteLine(CheckPhoneNumber("+47 420-053-934"));    // True
  }

  static bool CheckPhoneNumber(string phoneNumber)
  {
    string strRegex =
    @"(^[0-9]{10}$)|(^\+[0-9]{2}\s+[0-9]{2}[0-9]{8}$)|
    (^[0-9]{3}-[0-9]{4}-[0-9]{4}$)|(^\+\d{2}\s(\d{3}\-){2}(\d{3}))";

    // Class Regex Represents an
    // immutable regular expression.
    // Format               Pattern
    // xxxxxxxxxx           ^[0 - 9]{ 10}$
    // +xx xx xxxxxxxx      ^\+[0 - 9]{ 2}\s +[0 - 9]{ 2}\s +[0 - 9]{ 8}$
    // xxx - xxxx - xxxx    ^[0 - 9]{ 3} -[0 - 9]{ 4}-[0 - 9]{ 4}$
    // +xx xxx-xxx-xxx      ^\+[0-9]{2}\s+[0-9]{3}-[0-9]{3}-[0-9]{3}$
    Regex regex = new Regex(strRegex);
    Match match = regex.Match(phoneNumber);

    return match.Success;
  }
}