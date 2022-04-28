package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	public static Connection getConnection() {

		/*
		 * This URL includes the driver we're using, which is from Postgres as well as
		 * the computer (which is localhost) and the PORT which is 5432 by default
		 * 
		 * the last '/' is important because it refers to the specific db we're
		 * connecting to (If you only have one DB, you don't need to specify).
		 */

		// This is not secure!
		//String url = "jdbc:postgresql://localhost:5432/";
		//String username = "postgres";
		//String password = "postgres";

		Connection conn = null;

		try {
			// this is more secure as you don't expose all your credentials
			logger.debug(String.format(
					"Making a database credentials with following credentials: \nURL: %s \nUsername: %s \nPassword: %s", 
					System.getenv("db_url"), 
					System.getenv("db_username"), 
					System.getenv("db_password")
				)
			);
			conn = DriverManager.getConnection(
					System.getenv("db_url"), 
					System.getenv("db_username"), 
					System.getenv("db_password")
				);
			logger.debug("Connection has been successfully established.");
		} catch (SQLException e) {
			logger.warn("Unable to obtain connection to database", e);
		}

		return conn;
	}

}
