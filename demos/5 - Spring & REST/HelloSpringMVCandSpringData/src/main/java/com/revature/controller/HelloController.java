package com.revature.controller;

import java.util.List;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;


public interface HelloController {

	List<Hero> findAllHeroes();
	
	ClientMessage registerHero(Hero hero);
	
	Hero findHero(String name);
}
