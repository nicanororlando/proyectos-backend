using Catalog.Api.Entities;

namespace Catalog.Api.Repositories.InMemItems;

public interface IInMemItemsRepository
{
  Item GetItem(Guid id);
  IEnumerable<Item> GetItems();
  void CreateItem(Item item);
  void UpdateItem(Item item);
  void DeleteItem(Guid id);
}