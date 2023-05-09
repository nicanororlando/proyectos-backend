using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using PokemonReview.Api.Dtos;
using PokemonReview.Api.Models;
using PokemonReview.Api.Repositories.OwnerRepository;

namespace PokemonReview.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OwnerController : Controller
    {
        private readonly IMapper _mapper;
        private readonly IOwnerRepository _ownerRepository;

        public OwnerController(IOwnerRepository ownerRepository, IMapper mapper)
        {
            _mapper = mapper;
            _ownerRepository = ownerRepository;
        }

        [HttpGet]
        [ProducesResponseType(200, Type = typeof(ICollection<Owner>))]
        public IActionResult GetOwners()
        {
            var owners = _mapper.Map<List<OwnerDto>>(_ownerRepository.GetOwners());

            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(owners);
        }

        [HttpGet("{ownerId}")]
        [ProducesResponseType(200, Type = typeof(Owner))]
        [ProducesResponseType(400)]
        public IActionResult GetOwner(int ownerId)
        {
            if (!_ownerRepository.OwnerExist(ownerId))
                return NotFound();

            var owner = _mapper.Map<OwnerDto>(_ownerRepository.GetOwner(ownerId));
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(owner);
        }

        [HttpGet("{pokemonId}/owners")]
        [ProducesResponseType(200, Type = typeof(Owner))]
        [ProducesResponseType(400)]
        public IActionResult GetOwnersOfAPokemon(int pokemonId)
        {
            if (!_ownerRepository.OwnerExist(pokemonId))
                return NotFound();

            var owners = _mapper.Map<List<OwnerDto>>(
                _ownerRepository.GetOwnersOfAPokemon(pokemonId)
            );
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(owners);
        }

        [HttpGet("{ownerId}/pokemon")]
        [ProducesResponseType(200, Type = typeof(Pokemon))]
        [ProducesResponseType(400)]
        public IActionResult GetPokemonByOwner(int ownerId)
        {
            if (!_ownerRepository.OwnerExist(ownerId))
                return NotFound();

            var pokemon = _mapper.Map<List<PokemonDto>>(
                _ownerRepository.GetPokemonsByOwner(ownerId)
            );
            if (!ModelState.IsValid)
                return BadRequest(ModelState);

            return Ok(pokemon);
        }
    }
}
