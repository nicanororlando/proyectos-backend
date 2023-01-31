using Catalog.Api.Dtos;
using Catalog.Api.Entities;
using Catalog.Api.Extensions;
using Catalog.Api.Repositories.Items;
using Microsoft.AspNetCore.Mvc;

namespace Catalog.Api.Controllers;

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
  public async Task<IEnumerable<ItemDto>> GetItemsAsync()
  {
    // We have to transform the type 'Item' into an 'ItemDto'. We use our 'Extension' AsDto().
    var items = (await repository.GetItemsAsync()).Select(item => item.AsDto());
    return items;
  }

  [HttpGet("{id}")]
  public async Task<ActionResult<ItemDto>> GetItemAsync(Guid id)
  {
    Item item = await repository.GetItemAsync(id);
    if (item is null) return NotFound();

    else return item.AsDto();
  }

  [HttpPost]
  public async Task<ActionResult<ItemDto>> CreateItemAsync(CreateItemDto itemDto)
  {
    Item item = new()
    {
      Id = Guid.NewGuid(),
      Name = itemDto.Name,
      Price = itemDto.Price,
      CreatedDate = DateTimeOffset.UtcNow
    };

    await repository.CreateItemAsync(item);

    return CreatedAtAction(nameof(GetItemAsync), new { id = item.Id }, item.AsDto());
  }

  [HttpPut("{id}")]
  public async Task<ActionResult> UpdateItemAsync(Guid id, UpdateItemDto itemDto)
  {
    var existingItem = await repository.GetItemAsync(id);
    if (existingItem is null) return NotFound();

    // In this with expression we are creating a copy of the item, with the following properties modified.
    Item updatedItem = existingItem with
    {
      Name = itemDto.Name,
      Price = itemDto.Price
    };

    await repository.UpdateItemAsync(updatedItem);

    return NoContent();
  }

  [HttpDelete("{id}")]
  public async Task<ActionResult> DeleteItemAsync(Guid id)
  {
    var existingItem = repository.GetItemAsync(id);
    if (existingItem is null) return NotFound();

    await repository.DeleteItemAsync(id);
    return NoContent();
  }
}