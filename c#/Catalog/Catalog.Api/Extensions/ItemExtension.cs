using Catalog.Api.Dtos;
using Catalog.Api.Entities;

namespace Catalog.Api.Extensions;

// We extend the definition of one type by adding methods that can be executed on that type.
public static class ItemExtension
{
  // Its goint to operate on the current Item. This receives an 'Item' and returnS an 'ItemDto' version.
  public static ItemDto AsDto(this Item item)
  {
    return new ItemDto
    {
      Id = item.Id,
      Name = item.Name,
      Price = item.Price,
      CreatedDate = item.CreatedDate
    };
  }
}