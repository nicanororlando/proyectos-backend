using AutoMapper;
using PokemonReview.Api.Models;
using PokemonReviewApp.Data;

namespace PokemonReview.Api.Repositories.CountryRepository
{
    public class CountryRepository : ICountryRepository
    {
        private readonly DataContext _context;
        private readonly IMapper _mapper;

        public CountryRepository(DataContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        public bool CountryExist(int id)
        {
            return _context.Countries.Any(c => c.Id == id);
        }

        public ICollection<Country> GetCountries()
        {
            return _context.Countries.OrderBy(c => c.Id).ToList();
        }

        public Country GetCountry(int id)
        {
            return _context.Countries.Where(c => c.Id == id).FirstOrDefault();
        }

        // Each Owner belongs to one country
        public Country GetCountryByOwner(int ownerId)
        {
            return _context.Owners
                .Where(o => o.Id == ownerId)
                .Select(c => c.Country)
                .FirstOrDefault();
        }

        // Many Owners can belong to the same Country
        // Multiple owners may belong to the same country
        public ICollection<Owner> GetOwnersFromACountry(int countryId)
        {
            // Returns Owners that have the same Id as the country
            return _context.Owners.Where(c => c.Country.Id == countryId).ToList();
        }
    }
}
