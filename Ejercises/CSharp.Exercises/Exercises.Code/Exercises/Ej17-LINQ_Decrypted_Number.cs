public class Ej17
{
  public static void main()
  {
    var chars = new char[] { ')', '!', '@', '#', '$', '%', '^', '&', '*', '(' };

    var encryptedNumber = "#(@*%)$(&$*#&";
    var decryptedNumber = string.Join("", encryptedNumber.Select(c => Array.IndexOf(chars, c)));

    Console.WriteLine(decryptedNumber); // 3928504974837
  }
}