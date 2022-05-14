package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.JdbcUtil;

public class UserDAOImpl implements UserDAO{
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	// connects JDBC to servlets
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			log.info("Static block has failed me: unable to connect JDBC to servlets. Exception message: " + e);
		}
	}

	
	@Override
	public int insert(User user) {
		log.info("adding user to database. User info: " + user);
		int isInserted = 0;
		// 1. create a connection using my ConnectionUtil class - try-with-resources
		try (Connection conn = JdbcUtil.getConnection()) {
			// 2. prepare my SQL statement using JDBC's PreparedStatement
			String sql = "insert into store_users (store_user_username, store_user_password, store_user_firstname, store_user_lastname) "
					+ "values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			
			// 3. executing that query
			isInserted = ps.executeUpdate();
			
			// 4. close db connection to avoid memory leaks
			conn.close();
		} catch(SQLException e) {
			log.warn("Unable to execute SQL statement", e);
			return isInserted;
		}
		
		log.info("insert successful!");
		return isInserted;
	}

	@Override
	public User selectById(int id) {
		log.info("searching user by id: " + id);
		
		User user = new User();
		
		try (Connection conn = JdbcUtil.getConnection()) {
			String sql = "SELECT * FROM store_users WHERE store_user_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user.setId(id);
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
			}
			
		} catch (SQLException e) {
			log.warn("Unable to execute SQL statement", e);
		}
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public User selectByFirstName(String firstName) {
		log.info("searching user by firstName: " + firstName);
		User user = new User();
		
		try (Connection conn = JdbcUtil.getConnection()) {
			String sql = "SELECT * FROM store_users WHERE store_user_firstname = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, firstName);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(firstName);
				user.setLastName(rs.getString(5));
			}
			
		} catch (SQLException e) {
			log.warn("Unable to execute SQL statement", e);
		}
		
		log.info("Search complete! Found: " + user);
		
		return user;
	}

	@Override
	public List<User> selectAll() {
		log.info("getting all users from database....");
		List<User> userList = new ArrayList<>();

		try (Connection conn = JdbcUtil.getConnection()) {
			String sql = "select * from store_users order by store_user_id ASC;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//1. get information out of the resultSet for each record
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String firstname = rs.getString(4);
				String lastname = rs.getString(5);

				//2. make a object that matches that record info
				User u = new User(id, username, password, firstname, lastname);

				//3. add item into our list
				userList.add(u);
			}
			
			int size = 0;
			if (rs != null) 
			{
			  rs.last();    // moves cursor to the last row
			  size = rs.getRow(); // get row id 
			}
			
			log.info("List has been successfully retrieved from DB. Number of users: " + size);
			//4. close the resultSet
			rs.close();
			
			//5. close connection
			conn.close();
		} catch (SQLException e) {
			log.warn("Unable to retrieve products from the database", e);
		}
		
		log.info("User list retrieved! Size: " + userList.size());
		return userList;
	}

	@Override
	public boolean update(User user) {
		log.info("Updating user. User info: " + user);
		
		try (Connection conn = JdbcUtil.getConnection()) {
			// now updating users table
			String sql = "update store_users set "
					+ "store_user_username=?, "
					+ "store_user_password=?, "
					+ "store_user_firstname=?, "
					+ "store_user_lastname=? "
					+ "where store_user_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getId());
			stmt.executeUpdate();

			log.info("User update for ID " + user.getId() + " was successful. ");

		} catch (SQLException e) {
			log.warn("Unable to execute SQL statement", e);
			return false;
		}
		
		log.info("update complete");
		
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		log.info("Deleting user. User info: " + id);
		
		try (Connection conn = JdbcUtil.getConnection()) {
			// now removing user from table
			String sql = "delete from store_users where store_user_id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			log.info("User removal for ID " + id + " was successful. ");

		} catch (SQLException e) {
			log.warn("Unable to execute SQL statement", e);
			return false;
		}
		
		log.info("deletion complete");
		
		return true;
	}

}
