using PokemonReview.Api.Models;

namespace PokemonReview.Api.Repositories.CategoryRepository
{
    public interface ICategoryRepository
    {
        ICollection<Category> GetCategories();
        Category GetCategory(int id);
        ICollection<Pokemon> GetPokemonByCategory(int categoryId);
        bool CategoryExist(int id);
    }
}
