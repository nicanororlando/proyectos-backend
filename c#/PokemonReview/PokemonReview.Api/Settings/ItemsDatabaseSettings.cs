namespace Catalog.Api.Settings;
public class ItemsDatabaseSettings
{
  public string ConnectionString { get; set; } = string.Empty;
  public string DatabaseName { get; set; } = string.Empty;
  public string CollectionName { get; set; } = string.Empty;
}