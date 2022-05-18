package com.revature.service;

import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.model.Pokemon;

public class PokemonServiceImpl implements PokemonService {

	private PokemonDao pokeDao;
	
	//constructor injection
	public PokemonServiceImpl(PokemonDao pokeDao) {
		this.pokeDao = pokeDao;
	}
	
	//-----------------------------------------
	
	//two examples of setter injection
	
	//default constructor for setter injection that the config file will be working with
	//will be doing it from the config file
	public PokemonServiceImpl() {}
	
	//setter injection manually thru a setter
	public void setPokeDao(PokemonDao pokeDao) {
		this.pokeDao = pokeDao;
	}
	
	//this is the same as this:
	//private static PokemonDao pokeDao = new PokemonDaoImpl();
	
	@Override
	public List<Pokemon> getAll() {
		return pokeDao.getAllPokemon();
	}

}
