namespace PokemonReview.Api.Models
{
    public class Pokemon
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime BirthDate { get; set; }
        public ICollection<Review> Reviews { get; set; }

        // Many to many relationship
        public ICollection<PokemonOwner> PokemonOwners { get; set; }

        // Many to many relationship
        public ICollection<PokemonCategory> PokemonCategories { get; set; }
    }
}
