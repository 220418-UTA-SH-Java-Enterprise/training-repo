package com.revature.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pokemon {
	private int pokeId;
	private String pokemonName;
	private String pokeType;
	private int attackPower;
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(String pokemonName, String pokeType, int attackPower) {
		super();
		this.pokemonName = pokemonName;
		this.pokeType = pokeType;
		this.attackPower = attackPower;
	}

	public Pokemon(int pokeId, String pokemonName, String pokeType, int attackPower) {
		super();
		this.pokeId = pokeId;
		this.pokemonName = pokemonName;
		this.pokeType = pokeType;
		this.attackPower = attackPower;
	}
}
