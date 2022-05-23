package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ClientMessage;
import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pokemon")
@Api(value = "PokemonRestController", description = "REST controller related to Pokemon Entities")
public class PokemonController {
	
	@Autowired
	private PokemonService pokeService;
	
	@ApiOperation(value="Find pokemon by pokedex id number", notes="Provide a Pokedex id to lookup a specific pokemon from the API", response = Pokemon.class)
	@GetMapping(path = "/id-lookup")
	public @ResponseBody Pokemon getByDexId(@RequestParam int dexid) {
		return pokeService.getPokemonById(dexid);
	}
	
	@ApiOperation(value="Get a list of all pokemon owned by given trainer id")
	@GetMapping("/owned")
	public @ResponseBody List<Pokemon> getAllByTrainerId(@RequestParam int trainerId) {
		return pokeService.getAllPokemonByTrainerId(trainerId);
	}
	
	@ApiOperation(value="Get a list of all pokemon in API system")
	@GetMapping("/all")
	public @ResponseBody List<Pokemon> getAll() {
		return pokeService.getAllPokemon();
	}
	
	@ApiOperation(value="Create a new pokemon entity to the API")
	@PostMapping("/")
	public @ResponseBody ClientMessage createPokemon(@RequestBody Pokemon pokemon) {
		return pokeService.createPokemon(pokemon) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@ApiOperation(value="Update details to an existing pokemon")
	@PutMapping("/")
	public @ResponseBody ClientMessage updatePokemon(@RequestBody Pokemon pokemon) {
		return pokeService.updatePokemon(pokemon) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@ApiOperation(value="Remove an existing pokemon")
	@DeleteMapping("/")
	public @ResponseBody ClientMessage deletePokemon(@RequestBody Pokemon pokemon) {
		return pokeService.deletePokemon(pokemon) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

}
