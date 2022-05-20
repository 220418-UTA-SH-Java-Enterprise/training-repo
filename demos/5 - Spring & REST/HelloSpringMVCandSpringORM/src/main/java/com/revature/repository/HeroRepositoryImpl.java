package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Hero;

@Repository
@Transactional
public class HeroRepositoryImpl implements HeroRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public int insert(Hero hero) {
		
		return (int) sessionFactory.getCurrentSession().save(hero);
		
	}

	@SuppressWarnings("unchecked")
	public List<Hero> findAll() {
		
		// Criteria API -> this is a framework specific method to query objects in Hibernate
		return sessionFactory.getCurrentSession().createCriteria(Hero.class).list();
		
	}

	public Hero findByName(String name) {

		return (Hero) sessionFactory.getCurrentSession().createCriteria(Hero.class).add(Restrictions.like("name", name)).list().get(0);
	}

}
