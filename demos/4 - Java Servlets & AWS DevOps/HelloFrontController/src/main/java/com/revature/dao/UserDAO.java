package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	//basic CRUD operations
	//CREATE, READ, UPDATE, AND DELETE
	public int insert(User user);
	
	public User selectById(int id);
	
	public User selectByFirstName(String firstName);
	
	public List<User> selectAll();
	
	public boolean update(User user);
	
	public boolean delete(User user);
}
