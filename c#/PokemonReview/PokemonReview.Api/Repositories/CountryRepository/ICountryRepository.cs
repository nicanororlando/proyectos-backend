using PokemonReview.Api.Models;

namespace PokemonReview.Api.Repositories.CountryRepository
{
    public interface ICountryRepository
    {
        ICollection<Country> GetCountries();
        Country GetCountry(int id);
        Country GetCountryByOwner(int ownerId);
        ICollection<Owner> GetOwnersFromACountry(int countryId);
        bool CountryExist(int id);
    }
}
