namespace Catalog.Api.Entities;

public record Item
{

  // Shorcut --> prop 
  // public Guid Id { get; private set; }  // also we can do with this form, but it's more complex to build constructors later.
  public Guid Id { get; init; } // init only allow setting a value during initialization. Like an inmutable property.
  public string Name { get; init; }
  public decimal Price { get; init; }
  public DateTimeOffset CreatedDate { get; init; }
}

// public class Item
// {
//   private Guid id;
//   private String name;
//   private decimal price;
//   private DateTimeOffset createdDate;


//   public Guid Id { get { return id; } set { id = value; } }
//   public string Name { get { return name; } set { name = value; } }
//   public decimal Price { get { return price; } set { price = value; } }
//   public DateTimeOffset CreatedDate { get { return createdDate; } set { createdDate = value; } }
// }