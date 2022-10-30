using static c.sharp.UserInput;

// // USER INPUT
// c.sharp.UserInput userInput = new c.sharp.UserInput();
// userInput.swapNumbers();

// // HUMAN
// c.sharp.Human human = new c.sharp.Human();
// Console.WriteLine("\nDefault name: " + human.Name);

// c.sharp.Human michael = new c.sharp.Human();
// michael.Name = "Michael";
// Console.WriteLine("Name: " + michael.Name);

// LIST
c.sharp.List list = new c.sharp.List();
var friends = new List<string> { "Frank", "Canor", "Joe", "Michelle", "Andy", "Maria", "Carlos" };
var partyFriends = list.getPartyFriends(friends, 4);
foreach (var name in partyFriends) Console.WriteLine(name);