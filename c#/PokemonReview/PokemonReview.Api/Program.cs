using Microsoft.EntityFrameworkCore;
using PokemonReview.Api.Repositories.CategoryRepository;
using PokemonReview.Api.Repositories.CountryRepository;
using PokemonReview.Api.Repositories.OwnerRepository;
using PokemonReview.Api.Repositories.PokemonRepository;
using PokemonReviewApp;
using PokemonReviewApp.Data;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();

// 'AddTransient' to add the object injection at the begining
builder.Services.AddTransient<Seed>();

builder.Services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());

// TODO To wire up the Dependency Injection
builder.Services.AddScoped<IPokemonRepository, PokemonRepository>();
builder.Services.AddScoped<ICategoryRepository, CategoryRepository>();
builder.Services.AddScoped<ICountryRepository, CountryRepository>();
builder.Services.AddScoped<IOwnerRepository, OwnerRepository>();

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();

// builder.Services.AddCors();
builder.Services.AddSwaggerGen();

// Adding the Mysql connection string.
var connectionString = builder.Configuration.GetConnectionString("MySqlConnection");
builder.Services.AddDbContext<DataContext>(
    options => options.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString))
);

var app = builder.Build();

if (args.Length == 1 && args[0].ToLower() == "seeddata")
    SeedData(app);

void SeedData(IHost app)
{
    var scopedFactory = app.Services.GetService<IServiceScopeFactory>();
    using (var scope = scopedFactory.CreateScope())
    {
        var service = scope.ServiceProvider.GetService<Seed>();
        service.SeedDataContext();
    }
}

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// TODO Important to enable CORS:
app.UseCors(
    builder =>
        builder
            .WithOrigins("http://localhost:5128", "https://localhost:7199")
            .AllowAnyHeader()
            .AllowCredentials()
            .AllowAnyMethod()
);

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
