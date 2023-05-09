using PokemonReview.Api.Models;

namespace PokemonReview.Api.Repositories.OwnerRepository
{
    public interface IOwnerRepository
    {
        ICollection<Owner> GetOwners();
        Owner GetOwner(int id);
        ICollection<Owner> GetOwnersOfAPokemon(int pokeId);
        ICollection<Pokemon> GetPokemonsByOwner(int ownerId);
        bool OwnerExist(int ownerId);
    }
}
