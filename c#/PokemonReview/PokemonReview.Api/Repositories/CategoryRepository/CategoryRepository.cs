using PokemonReview.Api.Models;
using PokemonReviewApp.Data;

namespace PokemonReview.Api.Repositories.CategoryRepository
{
    public class CategoryRepository : ICategoryRepository
    {
        // To access to our database:
        private DataContext _context;

        public CategoryRepository(DataContext context)
        {
            _context = context;
        }

        public bool CategoryExist(int id)
        {
            return _context.Categories.Any(c => c.Id == id);
        }

        public ICollection<Category> GetCategories()
        {
            // Other way to return our collection of data:
            return _context.Categories.ToList();
        }

        public Category GetCategory(int id)
        {
            return _context.Categories.Where(e => e.Id == id).FirstOrDefault();
        }

        public ICollection<Pokemon> GetPokemonByCategory(int categoryId)
        {
            return _context.PokemonCategories
                .Where(e => e.CategoryId == categoryId)
                .Select(c => c.Pokemon)
                .ToList();
        }
    }
}
