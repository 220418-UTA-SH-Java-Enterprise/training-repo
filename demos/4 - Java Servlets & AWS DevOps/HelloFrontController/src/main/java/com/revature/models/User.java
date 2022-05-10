package com.revature.models;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="store_users")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_user_id")
	private int id;
	
	@Column(name="store_user_username")
	private String username;
	
	@Column(name="store_user_password")
	private String password;
	
	@Column(name="store_user_firstname")
	private String firstName;
	
	@Column(name="store_user_lastname")
	private String lastName;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
