package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDAOImpl implements UserDAO{
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public int insert(User user) {
		log.info("adding user to database. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(user);
		
		tx.commit();
		
		log.info("insert successful! New user id is " + pk);
		return pk; //return the auto-generated pk
	}

	@Override
	public User selectById(int id) {
		log.info("searching user by id: " + id);
		
		Session ses = HibernateUtil.getSession();
		
		User user = (User) ses.createNativeQuery("SELECT * FROM store_users WHERE store_user_id = " + id + "", User.class).getSingleResult();
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public User selectByFirstName(String firstName) {
		log.info("searching user by firstName: " + firstName);
		
		Session ses = HibernateUtil.getSession();
		
		User user = (User) ses.createNativeQuery("SELECT * FROM store_users WHERE store_user_firstname = '" + firstName + "'", User.class).getSingleResult();
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public List<User> selectAll() {
		log.info("getting all users from database....");
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("from User", User.class).list();
		log.info("User list retrieved! Size: " + userList.size());
		return userList;
	}

	@Override
	public boolean update(User user) {
		log.info("Updating user. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.update(user);
		
		tx.commit();
		
		log.info("update complete");
		
		return true;
	}

	@Override
	public boolean delete(User user) {
		log.info("Deleting user. User info: " + user);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.delete(user);
		
		tx.commit();
		
		log.info("deletion complete");
		
		return true;
	}

}
