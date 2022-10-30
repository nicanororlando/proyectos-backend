// THIS PROJECT IS BASED ON THE FOLLOWING VIDEO:
// https://www.youtube.com/watch?v=ZXdFisA_hOY


using Catalog.Repositories;
using Catalog.Repositories.InMemItems;
using Catalog.Repositories.Items;
using Catalog.Settings;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

// Agrego mi propia configuracion de 'appsetings.json'.
builder.Services.Configure<ItemsDatabaseSettings>(builder.Configuration.GetSection("ItemsDatabaseSettings"));

// AddSingleton agrega una copia de la instancia del tipo a traves de todo el ciclo de vida del servicio.
// builder.Services.AddSingleton<IInMemItemsRepository, InMemItemsRepository>();
builder.Services.AddSingleton<IItemsRepository, ItemsRepository>();

builder.Services.AddControllers();
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
