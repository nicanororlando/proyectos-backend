namespace Catalog.Dtos;

/* El patrón DTO tiene como finalidad de crear un objeto plano (POJO) con una serie de atributos que puedan ser enviados 
o recuperados del servidor en una sola invocación, de tal forma que un DTO puede contener información de múltiples fuentes 
o tablas y concentrarlas en una única clase simple. 
  Otra de las ventajas del DTO es que nos permite omitir información que el usuario no requiere, de esta forma no estamos 
enviando informacion de mas al cliente. */
public record ItemDto
{
  public Guid Id { get; init; } // init only allow setting a value during initialization. Like an inmutable property.
  public string Name { get; init; }
  public decimal Price { get; init; }
  public DateTimeOffset CreatedDate { get; init; }
}