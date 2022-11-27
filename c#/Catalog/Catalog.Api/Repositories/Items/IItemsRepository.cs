using Catalog.Api.Entities;

namespace Catalog.Api.Repositories.Items;

public interface IItemsRepository
{
  /* When using 'Task', im sayng tbat it is not going to return the Item right away, instead we 
  are going to get a task that represent an asyncronus operation that eventually is going to return 
  the Item. */
  Task<Item> GetItemAsync(Guid id);
  Task<IEnumerable<Item>> GetItemsAsync();
  Task CreateItemAsync(Item item);
  Task UpdateItemAsync(Item item);
  Task DeleteItemAsync(Guid id);
}