package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	private static Session ses;
	
	public static Session getSession() {
		if(ses == null) {
			ses = sf.openSession(); //this returns a JDBC connection
		}
		
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
		sf.close();
	}
}
