package com.revature.services;

//ctrl+shift+o to put in import via intellisense
import com.revature.models.User;

//interfaces are contracts with a subclass to use its methods/behaviors
public interface UserService {
	
	public User addUser(User u);
	
	public User editUser(User u);
	
	public String getUserById(int id);
	
	public void deleteUser(User u);
}
