using Catalog.Dtos;
using Catalog.Entities;
using Catalog.Extensions;
using Catalog.Repositories.InMemItems;
using Catalog.Repositories.Items;
using Microsoft.AspNetCore.Mvc;

namespace Catalog.Controllers;

// https://localhost:7019/Items

// This brings a bunch of additional default behaviors for our controller class.
[ApiController]
// [Route("items")]
[Route("[controller]")] // It's the same. '[controller]' will be take the name if this controller.
public class ItemsController : ControllerBase
{
  // private readonly IInMemItemsRepository repository;
  private readonly IItemsRepository repository;

  public ItemsController(IItemsRepository repository)
  {
    this.repository = repository;
  }

  // [HttpGet]
  // public IEnumerable<Item> GetItems()
  // {
  //   return repository.GetItems();
  // }
  [HttpGet]
  public IEnumerable<ItemDto> GetItems()
  {
    // We have to transform the type 'Item' into an 'ItemDto'. We use our 'Extension' AsDto().
    var items = repository.GetItems().Select(item => item.AsDto());
    return items;
  }

  [HttpGet("{id}")]
  public ActionResult<ItemDto> GetItem(Guid id)
  {
    Item item = repository.GetItem(id);
    if (item is null) return NotFound();

    else return item.AsDto();
  }

  [HttpPost]
  public ActionResult<ItemDto> CreateItem(CreateItemDto itemDto)
  {
    Item item = new()
    {
      Id = Guid.NewGuid(),
      Name = itemDto.Name,
      Price = itemDto.Price,
      CreatedDate = DateTimeOffset.UtcNow
    };

    repository.CreateItem(item);

    return CreatedAtAction(nameof(GetItem), new { id = item.Id }, item.AsDto());
  }

  [HttpPut("{id}")]
  public ActionResult UpdateItem(Guid id, UpdateItemDto itemDto)
  {
    var existingItem = repository.GetItem(id);
    if (existingItem is null) return NotFound();

    // In this with expression we are creating a copy of the item, with the following properties modified.
    Item updatedItem = existingItem with
    {
      Name = itemDto.Name,
      Price = itemDto.Price
    };

    repository.UpdateItem(updatedItem);

    return NoContent();
  }

  [HttpDelete("{id}")]
  public ActionResult DeleteItem(Guid id)
  {
    var existingItem = repository.GetItem(id);
    if (existingItem is null) return NotFound();

    repository.DeleteItem(id);
    return NoContent();
  }
}