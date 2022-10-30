namespace c.sharp;

class List
{

  public List() { }

  public List<string> getPartyFriends(List<string> list, int count)
  {
    var partyFriends = new List<string>();
    while (partyFriends.Count < count)
    {
      var currentFriend = getPartyFriend(list);
      partyFriends.Add(currentFriend);
      list.Remove(currentFriend);
    }

    return partyFriends;
  }

  public string getPartyFriend(List<string> list)
  {
    string shortestName = list[0];
    for (int i = 0; i < list.Count; i++)
    {
      if (list[i].Length < shortestName.Length) shortestName = list[i];
    }

    return shortestName;
  }
}