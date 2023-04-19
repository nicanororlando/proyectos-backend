# MySql db configuration

Steps I've followed:

1. Install the MySQL Connector/NET driver:
   https://dev.mysql.com/downloads/connector/net/
2. Add this line to the .csproj file:
   <PackageReference Include="MySql.Data" Version="x.x.x" />
   and replace the current version installed.
3. # Install: `dotnet add Microsoft.EntityFrameworkCore`
4. Create the '/Data/DataContext.cs file'.
5. Create the 'ConnectionString" in appsettings.json file.
6. Configure Entity Framework Core in 'Program.cs' file.
7. Create a Seed with the initial data, or maybe the controllers with the DataContext object.
8. In this case we have initial data, so it'll be located in the 'Seed.cs' file.
9. Then I configure the seed data in the 'Program.cs' file.
10. Finally, we should initializate the database, and for that we have to do the following steps:

Once finished the configuration, follow this steps:

1. # Install `dotnet add package Microsoft.EntityFrameworkCore.Tools`
2. If not installed yet: `dotnet tool install --global dotnet-ef`
3. # Install `dotnet ef migrations add InitialData --context DataContext`
4. Run `dotnet ef database update --context DataContext`
5. To seed or pass the data: `dotnet run seeddata`
