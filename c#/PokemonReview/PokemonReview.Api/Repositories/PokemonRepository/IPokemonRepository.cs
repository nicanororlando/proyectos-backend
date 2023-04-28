using PokemonReview.Api.Models;

namespace PokemonReview.Api.Repositories.PokemonRepository
{
    public interface IPokemonRepository
    {
        ICollection<Pokemon> GetPokemons();
        Pokemon GetPokemon(int id);
        Pokemon GetPokemon(string name);
        decimal GetPokemonRating(int pokeId);
        bool PokemonExist(int pokeId);
    }
}
