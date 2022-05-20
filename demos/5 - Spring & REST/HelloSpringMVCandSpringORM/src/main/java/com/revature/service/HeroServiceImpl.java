package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

@Service("heroServiceImpl")
public class HeroServiceImpl implements HeroService {
	
	//since this service layer relies on the repository
	@Autowired
	HeroRepository heroRepository;

	@Override
	public boolean registerHero(Hero hero) {
		int pk = heroRepository.insert(hero);
		return (pk > 0) ? true : false;
	}

	@Override
	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}

	@Override
	public Hero getHero(String name) {
		return heroRepository.findByName(name);
	}

}
