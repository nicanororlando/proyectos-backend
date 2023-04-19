using Microsoft.EntityFrameworkCore;
using PokemonReview.Api.Models;

public class MySqlDbContext : DbContext
{
    public MySqlDbContext(DbContextOptions<MySqlDbContext> options)
        /* Base is going to shov (empujar) or push the data that's going to be received from the outside
        class up, into the DbContext */
        : base(options) { }

    public DbSet<Category> Categories { get; set; }
    public DbSet<Country> Countries { get; set; }
    public DbSet<Owner> Owners { get; set; }
    public DbSet<Pokemon> Pokemon { get; set; }
    public DbSet<PokemonOwner> PokemonOwners { get; set; }
    public DbSet<PokemonCategory> PokemonCategories { get; set; }
    public DbSet<Review> Reviews { get; set; }
    public DbSet<Reviewer> Reviewers { get; set; }

    // Here we configure how to customize our tables without having to go to the database.
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        base.OnModelCreating(modelBuilder);

        // Configure the entity mappings:
        /* In this case, to configure the many to many relationships, linking the foreignKeys will allow
        the Entity Framework that we want to link this following two ids for creating the relationship. */
        modelBuilder.Entity<PokemonCategory>().HasKey(pc => new { pc.PokemonId, pc.CategoryId });
        modelBuilder
            .Entity<PokemonCategory>()
            .HasOne(p => p.Pokemon)
            .WithMany(pc => pc.PokemonCategories)
            .HasForeignKey(c => c.PokemonId);
        modelBuilder
            .Entity<PokemonCategory>()
            .HasOne(p => p.Category)
            .WithMany(pc => pc.PokemonCategories)
            .HasForeignKey(c => c.CategoryId);

        modelBuilder.Entity<PokemonOwner>().HasKey(po => new { po.PokemonId, po.OwnerId });
        modelBuilder
            .Entity<PokemonOwner>()
            .HasOne(p => p.Pokemon)
            .WithMany(pc => pc.PokemonOwners)
            .HasForeignKey(c => c.PokemonId);
        modelBuilder
            .Entity<PokemonOwner>()
            .HasOne(p => p.Owner)
            .WithMany(pc => pc.PokemonOwners)
            .HasForeignKey(c => c.OwnerId);
    }
}
