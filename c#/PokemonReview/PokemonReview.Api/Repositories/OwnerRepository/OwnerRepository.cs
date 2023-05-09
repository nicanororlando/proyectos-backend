using PokemonReview.Api.Models;
using PokemonReviewApp.Data;

namespace PokemonReview.Api.Repositories.OwnerRepository
{
    public class OwnerRepository : IOwnerRepository
    {
        private readonly DataContext _dataContext;

        public OwnerRepository(DataContext dataContext)
        {
            _dataContext = dataContext;
        }

        public Owner GetOwner(int id)
        {
            return _dataContext.Owners.Where(o => o.Id == id).FirstOrDefault();
        }

        public ICollection<Owner> GetOwners()
        {
            return _dataContext.Owners.OrderBy(o => o.Id).ToList();
        }

        public ICollection<Owner> GetOwnersOfAPokemon(int pokeId)
        {
            return _dataContext.PokemonOwners
                // In the whole list of POwners, we filter the ones that have the 'pokeId':
                .Where(p => p.Pokemon.Id == pokeId)
                // Now we have the pokemonOwners filtered, but we need to return Only the Owners so now we Select:
                .Select(o => o.Owner)
                // And list all:
                .ToList();
        }

        public ICollection<Pokemon> GetPokemonsByOwner(int ownerId)
        {
            return _dataContext.PokemonOwners
                .Where(o => o.Owner.Id == ownerId)
                .Select(p => p.Pokemon)
                .ToList();
        }

        public bool OwnerExist(int ownerId)
        {
            return _dataContext.Owners.Any(o => o.Id == ownerId);
        }
    }
}
