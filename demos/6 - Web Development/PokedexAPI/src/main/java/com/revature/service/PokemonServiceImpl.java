package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Pokemon;
import com.revature.repository.PokemonRepository;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService{
	
	@Autowired
	private PokemonRepository pokemonRepo;

	@Override
	public boolean createPokemon(Pokemon pokemon) {
		int pk = pokemonRepo.save(pokemon).getDexid();
		return (pk > 0) ? true : false;
	}

	@Override
	public Pokemon getPokemonById(int dexid) {
		return pokemonRepo.findById(dexid);
	}

	@Override
	public List<Pokemon> getAllPokemonByTrainerId(int trainerId) {
		return pokemonRepo.findAllByTrainerId(trainerId);
	}

	@Override
	public List<Pokemon> getAllPokemon() {
		return pokemonRepo.findAll();
	}

	@Override
	public boolean updatePokemon(Pokemon pokemon) {
		return (pokemonRepo.update(pokemon.getName(), pokemon.getType1(), pokemon.getType2(), pokemon.getAbility(), pokemon.getMove(), pokemon.getTrainer().getTrainerId(), pokemon.getDexid()) != 0) ? true : false;
	}

	@Override
	public boolean deletePokemon(Pokemon pokemon) {
		try {
			pokemonRepo.delete(pokemon);
			return true;
		}catch(Exception e) {
			System.out.println("Error occur during deletion:: " + e);
			return false;
		}
	}

}
