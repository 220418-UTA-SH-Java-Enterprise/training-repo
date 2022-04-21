package com.revature.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.revature.exceptions.*;

import com.revature.models.User;

public class UserServiceImpl implements UserService{

	public File createDBConnection() throws CustomFileException {
		//1. create a text file
		File myFile = new File("users.txt");
		try {
			if(myFile.createNewFile() == true) {
				//2. print successful connection to console
				System.out.println("File has been successfully created: " + myFile.getName());
			}else {
				System.out.println("File already exist.");
			}
		} catch (CustomFileException e) {
			throw new CustomFileException("Something went wrong in with the file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return myFile;
	}
	
	@Override
	public User addUser(User u) {
		try {
			//1. serialize our user (convert object to byte[])
			FileOutputStream output = new FileOutputStream(createDBConnection(), true);
			//2. write that binary data into our text file
			output.write(u.toString().getBytes());
			//3. print successful addition message
			System.out.println("New user has been created!");
			//4. close the file
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CustomFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User editUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserById(int id) {
		String data = "";
		
		try {
			data = new String(Files.readAllBytes(createDBConnection().toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

}
