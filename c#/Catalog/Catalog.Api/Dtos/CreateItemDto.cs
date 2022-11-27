using System.ComponentModel.DataAnnotations;

namespace Catalog.Api.Dtos;

public record CreateItemDto
{

  // shorcut --> prop
  [Required]
  public string Name { get; init; }

  [Required]
  [Range(1, 1000)]
  public decimal Price { get; init; }
}