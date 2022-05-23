package com.revature.service;

import java.util.List;

import com.revature.model.Pokemon;

public interface PokemonService {

	//create a new pokemon
	boolean createPokemon(Pokemon pokemon);
	
	//get pokemon by dexid
	Pokemon getPokemonById(int dexid);
	
	//get all pokemon owned by given trainer id
	List<Pokemon> getAllPokemonByTrainerId(int trainerId);
	
	//get all pokemon in system
	List<Pokemon> getAllPokemon();
	
	//update pokemon info
	boolean updatePokemon(Pokemon pokemon);
	
	//delete pokemon
	boolean deletePokemon(Pokemon pokemon);
}
