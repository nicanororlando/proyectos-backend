using AutoMapper;
using PokemonReview.Api.Dtos;
using PokemonReview.Api.Models;

namespace PokemonReview.Api.Helper
{
    public class MappingProfiles : Profile
    {
        public MappingProfiles()
        {
            CreateMap<Pokemon, PokemonDto>();
            CreateMap<Category, CategoryDto>();
            CreateMap<Country, CountryDto>();
            CreateMap<Owner, OwnerDto>();
        }
    }
}
