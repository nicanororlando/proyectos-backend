# Create project:

1. Create folder Exercises.Code
2. Into that folder, Run this command:  
   `dotnet new console -n CSharp.Exercises.Code`

# Create unit tests:

1. Create folder:
   `dotnet new xunit -n Exercises.UnitTests`
2. Into the terminal folder, Add reference:
   `dotnet add reference ..\Exercises.Code\CSharp.Exercises.Code.csproj`
3. If we have errors --> Ctrl + Shift + P --> 'omnisharp restart omnisharp'
