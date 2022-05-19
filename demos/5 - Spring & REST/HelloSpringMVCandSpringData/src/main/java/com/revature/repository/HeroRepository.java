package com.revature.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Hero;

@Repository
@Transactional
public interface HeroRepository extends JpaRepository<Hero, Integer>{

	@Query(value="SELECT * from heroes WHERE h_name=?", nativeQuery=true)
	public Hero findByName(String name);
}
