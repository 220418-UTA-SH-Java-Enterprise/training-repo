package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

/**
 * 3 different ways to wrtie complex queries
 * 
 * - HQL - Hibernate Query Language
 * - Criteria API 
 * - Native SQL 
 *
 */
public class SuperVillainDAO {
public int insert(SuperVillain svill) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(svill);
		
		tx.commit();
		return pk; // reutrn the auto-generated PK
	}
	
	// select all
	public List<SuperVillain> selectAll() {
		
		// HQL - Hibernate Query Language
		
		Session ses = HibernateUtil.getSession();
		
		/**
		 * HQL Hibernate Query Language
		 * Combo of SQL and OOP
		 */
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		// HQL will return instances of the SuperVillain.java class
		
		return villList;
	}
	
	public SuperVillain selectByName(String name) {
		
		Session ses = HibernateUtil.getSession();
		/**
		 * Native SQL querying
		 */
//		SuperVillain vill = (SuperVillain) ses.createNativeQuery("SELECT * FROM super_villains WHERE svill_name = '" +name+ "'", SuperVillain.class);
		
		/**
		 * Criteria API
		 */
//		SuperVillain vill = (SuperVillain) ses.createCriteria(SuperVillain.class).add(Restrictions.like("svill_name", name));
		
		/**
		  * HQL - Hibernate Query Language 
		  * */
		SuperVillain vill = (SuperVillain) ses.createQuery("from SuperVillain where name = '" +name+"'", SuperVillain.class);
		
		
		return vill;
	}
	
	public void update(SuperVillain vill) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(vill);
		
		tx.commit();
	}
	
	public void delete(SuperVillain vill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.delete(vill);
		
		tx.commit();
	}

}
