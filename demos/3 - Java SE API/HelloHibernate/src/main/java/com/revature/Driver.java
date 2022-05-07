package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDAO;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillainDAO;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

/*
 * Hibernate ORM is an object–relational mapping tool for the
 * Java programming language. It provides a framework for mapping
 * an object-oriented domain model to a relational database.
 * 
 * To learn more about Hibernate & JPA, check out this guide:
 * https://www.baeldung.com/learn-jpa-hibernate
 */
public class Driver {

	static CrimeDAO cdao = new CrimeDAO();
	public static void main(String[] args) {
		System.out.println("Running our Hibernate Demo ");
		
		Crime c1 = new Crime("Arson", "setting the city ablaze");
		Crime c2 = new Crime("Murder", "killing too many people");
		Crime c3 = new Crime("Rape", "unspeakable actions towards another person");
		Crime c4 = new Crime("Robbery", "took a granny's purse");
		Crime c5 = new Crime("Beauty", "why I wake looking too good this morning");

		// as of now make sure you're only mapping the Crime model, not the others because we haven't created them
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);
		cdao.insert(c4);
		cdao.insert(c5);
		
		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(c1);
		crimes.add(c3);
		
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City");
		
		SuperVillain joker = new SuperVillain("The Joker", "evilness", 1_000_000.00, crimes, arkham);
		
		// add the joker and arkham to the DB
		
		SuperPrisonDAO spdao = new SuperPrisonDAO();
		spdao.insert(arkham);
		
		
		SuperVillainDAO svdao = new SuperVillainDAO();
		svdao.insert(joker);
		
		System.out.println(svdao.selectAll());
	}

}
