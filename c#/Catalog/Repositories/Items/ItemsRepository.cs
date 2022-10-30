using Catalog.Entities;
using Catalog.Settings;
using Microsoft.Extensions.Options;
using MongoDB.Bson;
using MongoDB.Driver;

namespace Catalog.Repositories.Items;

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

  public ItemsRepository(IOptions<ItemsDatabaseSettings> options)
  {
    var client = new MongoClient(options.Value.ConnectionString);
    // This give us a reference to the collection. If we dont have the collection it'll be created automatically.
    itemsCollection = client.GetDatabase("Catalog").GetCollection<Item>("Items");
  }

  public void CreateItem(Item item)
  {
    itemsCollection.InsertOne(item);
  }

  public IEnumerable<Item> GetItems()
  {
    return itemsCollection.Find(new BsonDocument()).ToList();
  }

  public Item GetItem(Guid id)
  {
    throw new NotImplementedException();
  }

  public void UpdateItem(Item item)
  {
    throw new NotImplementedException();
  }

  public void DeleteItem(Guid id)
  {
    throw new NotImplementedException();
  }
}
