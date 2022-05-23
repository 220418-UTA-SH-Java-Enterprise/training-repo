package com.revature.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="pokemon")
@ApiModel(value = "Pokemon", description = "This model serves as basic model for all pokemon entity API operations")
public class Pokemon {

	@Id
	@Column(name = "dexid")
	@ApiModelProperty(name="PokeDex ID", 
	notes="an Integer value that serves as the unique identier for any pokemon entity",
	required = true,
	value = "1")
	private int dexid;

	@Column(name = "name", nullable = false, unique = true)
	@ApiModelProperty(name="Pokemon Name", 
	notes="a String value that serves as the Pokemon's name",
	required = true,
	value = "TEST_POKEMON_NAME")
	private String name;

	@Column(name = "type1", nullable = false)
	@ApiModelProperty(name="Pokemon Type 1", 
	notes="a String value that serves as the Pokemon's primary type",
	required = true,
	value = "TEST_POKEMON_TYPE_1")
	private String type1;

	@Column(name = "type2", nullable=true)
	@ApiModelProperty(name="Pokemon Type 2", 
	notes="a String value that serves as the Pokemon's secondary type (if it has one - optional)",
	value = "TEST_POKEMON_TYPE_2")
	private String type2;

	@Column(name = "ability", nullable = false)
	@ApiModelProperty(name="Pokemon Ability", 
	notes="a String value that serves as the Pokemon's special ability",
	required = true,
	value = "TEST_POKEMON_ABILITY")
	private String ability;
	
	@Column(name = "move", nullable = false)
	@ApiModelProperty(name="Pokemon Move", 
	notes="a String value that serves as the Pokemon's move command",
	required = true,
	value = "TEST_POKEMON_MOVE")
	private String move;
	
	@ManyToOne
	@JoinColumn(name="pokemon_trainer", referencedColumnName = "trainer_id", nullable = true)
	private Trainer trainer;
	
}
