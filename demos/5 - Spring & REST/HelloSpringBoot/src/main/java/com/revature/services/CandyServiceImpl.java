package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Candy;
import com.revature.repositories.CandyRepository;

@Service
@Transactional
public class CandyServiceImpl implements CandyService{
	
	@Autowired
	private CandyRepository crepo;

	@Override
	public boolean createCandy(Candy candy) {
		int pk = crepo.save(candy).getId();
		return (pk > 0) ? true : false;
	}

	//@SuppressWarnings("deprecation")
	@Override
	public Candy getCandyById(int id) {
		//return crepo.getById(id);
		return crepo.findById(id).stream().findFirst().get();
	}

	@Override
	public List<Candy> getAllCandies() {
		return crepo.findAll();
	}

	@Override
	public boolean updateCandy(Candy candy) {
		//return crepo.update(candy.getName(), candy.getPrice(), candy.getId());
		Candy target = crepo.findById(candy.getId()).stream().findFirst().get();
		target.setName(candy.getName());
		target.setPrice(candy.getPrice());
		return (crepo.save(target) != null) ? true : false;
	}

	@Override
	public boolean deleteCandy(Candy candy) {
		crepo.delete(candy);
		return true;
	}

}
