package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JdbcUtil {
	private static Logger logger = Logger.getLogger(JdbcUtil.class);

	public static Connection getConnection() {
		Connection conn = null;

		try {
			// The secure way
			// this is more secure as you don't expose all your credentials
//			logger.debug(String.format(
//					"Making a database connection with following credentials: \nURL: %s \nUsername: %s \nPassword: %s", 
//					System.getenv("db_url"), 
//					System.getenv("db_username"), 
//					System.getenv("db_password")
//				)
//			);
//			conn = DriverManager.getConnection(
//					System.getenv("db_url"), 
//					System.getenv("db_username"), 
//					System.getenv("db_password")
//				);

			// This is not secure!
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "postgres";

			logger.debug(String.format(
					"Making a database connection with following localhost credentials: \nURL: %s \nUsername: %s \nPassword: %s",
					url, username, password));
			conn = DriverManager.getConnection(url, username, password);
			logger.debug("Connection has been successfully established. Connection obj: " + conn.getSchema());
		} catch (SQLException e) {
			logger.warn("Unable to obtain connection to database", e);
		}

		return conn;
	}

}
