namespace Catalog.Repositories;

using Catalog.Entities;
using Catalog.Repositories.InMemItems;

public class InMemItemsRepository : IInMemItemsRepository
{
  private readonly List<Item> items = new() {
    new Item {Id = Guid.NewGuid(), Name = "Potion", Price = 9, CreatedDate = DateTimeOffset.UtcNow},
    new Item {Id = Guid.NewGuid(), Name = "Iron Sword", Price = 20, CreatedDate = DateTimeOffset.UtcNow},
    new Item {Id = Guid.NewGuid(), Name = "Bronze Shield", Price = 18, CreatedDate = DateTimeOffset.UtcNow},
  };

  public IEnumerable<Item> GetItems()
  {
    return items;
  }

  public Item GetItem(Guid id)
  {
    // If it finds the item will return it, and if not returns default.
    return items.Where(item => item.Id == id).SingleOrDefault();
  }

  public void CreateItem(Item item)
  {
    items.Add(item);
  }

  public void UpdateItem(Item item)
  {
    var index = items.FindIndex(existingItem => existingItem.Id == item.Id);
    items[index] = item;
  }

  public void DeleteItem(Guid id)
  {
    var index = items.FindIndex(existingItem => existingItem.Id == id);
    items.RemoveAt(index);
  }
}
