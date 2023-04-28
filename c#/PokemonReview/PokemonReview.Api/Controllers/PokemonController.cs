using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using PokemonReview.Api.Dtos;
using PokemonReview.Api.Models;
using PokemonReview.Api.Repositories.PokemonRepository;

namespace PokemonReview.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PokemonController : Controller
    {
        private readonly IPokemonRepository _pokemonRepository;
        private readonly IMapper _mapper;

        public PokemonController(IPokemonRepository pokemonRepository, IMapper mapper)
        {
            _pokemonRepository = pokemonRepository;
            _mapper = mapper;
        }

        [HttpGet]
        [ProducesResponseType(200, Type = typeof(ICollection<Pokemon>))]
        public IActionResult GetPokemons()
        {
            // TODO Every time we use the mapper, we have to add the date to map, to the MappingProfiles.cs file!
            //  We map the response to the DTO model, so we choose the data we want to send to the client:
            var pokemons = _mapper.Map<List<PokemonDto>>(_pokemonRepository.GetPokemons());

            // Tradicional form below (without mapping to the DTO):
            // var pokemons = _pokemonRepository.GetPokemons();

            // This method is to map mannualy the response we want to send to the client (not recomended)d:
            // var pokemonsMapping = new Pokemon(){
            //     Id = pokemons.Id,
            //     Name = pokemons.Name,
            //     BirthDate = pokemons.BirthDate
            // }};

            /* Its a form of validation that works behind the scenes. It is gonna catch any error 500 like, wrong arguments,
            empty data, wrong types, or if some data is required, ... */
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(pokemons);
        }

        [HttpGet("{pokeId}")]
        [ProducesResponseType(200, Type = typeof(Pokemon))]
        [ProducesResponseType(400)]
        public IActionResult GetPokemon(int pokeId)
        {
            if (!_pokemonRepository.PokemonExist(pokeId))
                return NotFound();

            // Tradicional form below (without mapping to the DTO):
            // var pokemon = _pokemonRepository.GetPokemon(pokeId);

            //  We map the response to the DTO model, so we choose the data we want to send to the client:
            var pokemon = _mapper.Map<PokemonDto>(_pokemonRepository.GetPokemon(pokeId));
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(pokemon);
        }

        [HttpGet("{pokeId}/rating")]
        [ProducesResponseType(200, Type = typeof(decimal))]
        [ProducesResponseType(400)]
        public IActionResult GetPokemonRating(int pokeId)
        {
            if (!_pokemonRepository.PokemonExist(pokeId))
                return NotFound();

            var rating = _pokemonRepository.GetPokemonRating(pokeId);
            if (!ModelState.IsValid)
                return BadRequest();

            return Ok(rating);
        }
    }
}
