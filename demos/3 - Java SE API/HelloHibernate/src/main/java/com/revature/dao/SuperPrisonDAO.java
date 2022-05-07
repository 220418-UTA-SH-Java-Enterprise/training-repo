package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.util.HibernateUtil;

public class SuperPrisonDAO {
	public int insert(SuperPrison sp) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(sp);
		
		tx.commit();
		
		return pk;
		
	}
	
	// select By id
	public SuperPrison selectById(int id) {
		
		// we don't need a transaction since we're just querying data from the db
		Session ses = HibernateUtil.getSession();
		
		// session method - we are invoking a simple query to return an object of type SuperPrison with the PK that we specify from the SuperPrison table
		SuperPrison sp = ses.get(SuperPrison.class, id);
		
		return sp;
	}
	
	// selectAll()
	public List<SuperPrison> selectAll(int id) {
		
		// HQL - Hibernate Query Language
		Session ses = HibernateUtil.getSession();
		
		/**
		 * HQL Hibernate Query Language
		 * Combo of SQL and OOP
		 */
		List<SuperPrison> prisonList = ses.createQuery("from SuperPrison", SuperPrison.class).list();
		
		// HQL will return instances of the SuperPrison.java class
		return prisonList;
	}
}
