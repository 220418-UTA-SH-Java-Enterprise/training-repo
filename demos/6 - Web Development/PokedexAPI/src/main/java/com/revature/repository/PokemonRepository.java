package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Pokemon;

@Repository
@Transactional
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{

	@Modifying
	@Query(value="UPDATE pokemon SET name=?1, type1=?2, type2=?3, ability=?4, move=?5, pokemon_trainer=?6 WHERE dexid=?7", nativeQuery = true)
	public int update(String name, String type1, String type2, String ability, String move, int trainerId, int id);
	
	@Query(value="SELECT * FROM pokemon where dexid=?1", nativeQuery = true)
	public Pokemon findById(int id);
	
	@Query(value="SELECT * FROM pokemon where pokemon_trainer=?1", nativeQuery = true)
	public List<Pokemon> findAllByTrainerId(int trainerId);
}
