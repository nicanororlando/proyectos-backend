using Catalog.Api.Entities;
using Catalog.Api.Settings;
using Microsoft.Extensions.Options;
using MongoDB.Bson;
using MongoDB.Driver;

namespace Catalog.Api.Repositories.Items;

public class ItemsRepository : IItemsRepository
{
  // MongoClient client = new MongoClient("mongodb+srv://root:root@cluster0.phgvp7r.mongodb.net/?retryWrites=true&w=majority");
  private readonly IMongoCollection<Item> itemsCollection;

  // public ItemsRepository(IMongoClient mongoClient)
  // {
  //   // This give us a reference to the database.
  //   IMongoDatabase database = mongoClient.GetDatabase("Catalog");
  //   // This give us a reference to the collection. If we dont have the collection it'll be created automatically.
  //   itemsCollection = client.GetDatabase("Catalog").GetCollection<Item>("Items");
  // }

  private readonly FilterDefinitionBuilder<Item> filterBuilder = Builders<Item>.Filter;

  public ItemsRepository(IOptions<ItemsDatabaseSettings> options)
  {
    var client = new MongoClient(options.Value.ConnectionString);
    // This give us a reference to the collection. If we dont have the collection it'll be created automatically.
    itemsCollection = client.GetDatabase("Catalog").GetCollection<Item>("Items");
  }

  public async Task CreateItemAsync(Item item)
  {
    await itemsCollection.InsertOneAsync(item);
  }

  public async Task<IEnumerable<Item>> GetItemsAsync()
  {
    return await itemsCollection.Find(new BsonDocument()).ToListAsync();
  }

  public async Task<Item> GetItemAsync(Guid id)
  {
    var filter = filterBuilder.Eq(item => item.Id, id);
    return await itemsCollection.Find(filter).SingleOrDefaultAsync();
  }

  public async Task UpdateItemAsync(Item item)
  {
    var filter = filterBuilder.Eq(existingItem => existingItem.Id, item.Id);
    await itemsCollection.ReplaceOneAsync(filter, item);
  }

  public async Task DeleteItemAsync(Guid id)
  {
    var filter = filterBuilder.Eq(item => item.Id, id);
    await itemsCollection.DeleteOneAsync(filter);
  }
}
