// THIS PROJECT IS BASED ON THE FOLLOWING VIDEO:
// https://www.youtube.com/watch?v=ZXdFisA_hOY

using Catalog.Api.Repositories.Items;
using Catalog.Api.Settings;
using MongoDB.Bson.Serialization;
using MongoDB.Bson.Serialization.Serializers;
using MongoDB.Bson;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

BsonSerializer.RegisterSerializer(new GuidSerializer(BsonType.String));
BsonSerializer.RegisterSerializer(new DateTimeOffsetSerializer(BsonType.String));

// Agrego mi propia configuracion de 'appsetings.json'.
builder.Services.Configure<ItemsDatabaseSettings>(builder.Configuration.GetSection("ItemsDatabaseSettings"));

// AddSingleton agrega una copia de la instancia del tipo a traves de todo el ciclo de vida del servicio.
builder.Services.AddSingleton<IItemsRepository, ItemsRepository>();

builder.Services.AddControllers(options =>
{
  options.SuppressAsyncSuffixInActionNames = false;
});
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
  app.UseSwagger();
  app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
