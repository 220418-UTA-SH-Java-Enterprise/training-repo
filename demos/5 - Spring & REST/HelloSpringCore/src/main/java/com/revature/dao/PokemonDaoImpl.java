package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Pokemon;

public class PokemonDaoImpl implements PokemonDao {

	@Override
	public List<Pokemon> getAllPokemon() {
		// here I am doing a fake database to return to end user
		List<Pokemon> dbPokemon = new ArrayList<>();
		
		dbPokemon.add(new Pokemon(1, "pikachu", "electric", 1500));
		dbPokemon.add(new Pokemon(2, "seel", "water", 900));
		dbPokemon.add(new Pokemon(3, "weedle", "bug", 100));
		dbPokemon.add(new Pokemon(4, "mewtwo", "psychic", 12000));
		dbPokemon.add(new Pokemon(5, "eevee", "normal", 400));
		
		return dbPokemon;
	}

}
