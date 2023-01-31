### CREATE the project:

`dotnet new webapi -n Catalog`

# Moving the project Into another package:

1. Create the folder 'Catalog.Api'
2. Delete folders: 'bin' and 'obj'.
3. Change file: Catalog.csproj --> Catalog.Api.csproj
4. Replace all names that maches:
   Catalog.csproj --> Catalog.Api.csproj
   Catalog.dll --> Catalog.Api.dll
   namespace Catalog --> namespace Catalog.Api
   using Catalog --> using Catalog.Api
5. In tasks.json change:
   "${workspaceFolder}/Catalog.csproj" --> "${workspaceFolder}/Catalog.Api/Catalog.Api.csproj"
6. In launch.json change:
   ${workspaceFolder} --> ${workspaceFolder}/Catalog.Api
7. After checking that everything is ok, build the project ---> `Ctrl + Shift + B `

# If we want to omit the above, we should create first the Folder: 'Catalog.Api' and within it execute the first command.

### UNIT TESTS

# Create the unit tests with 'XUnit':

1. Execute:
   `dotnet new xunit -n Catalog.UnitTests`
2. (OPTIONAL) If we want to run both Project and UnitTests:
3. Create the file 'build.proj'
4. Change in tasks:
   "${workspaceFolder}/Catalog.Api/Catalog.Api.csproj" --> "${workspaceFolder}/build.proj
5. Add reference to test the controller:
   `dotnet add reference ..\atalog.Api\Catalog.Api.csproj`
   Then we can see the reference in the Catalog.UnitTests file.
6. Install packages:
   `dotnet add package Microsoft.Extensions.Logging.Abstractions`
   We need this package because in the controller we receive a ILogger in the constructor, so then we need the ILogger class.
   `dotnet add package moq`
7. If we have errors --> Ctrl + Shift + P --> 'omnisharp restart omnisharp'

# Command is for installing a certification authority (CA) for this url:

`dotnet dev-certs https --trust`

# Run the project

`dotnet run`

# Add MongoDb package:

`dotnet add package MongoDB.Driver`
