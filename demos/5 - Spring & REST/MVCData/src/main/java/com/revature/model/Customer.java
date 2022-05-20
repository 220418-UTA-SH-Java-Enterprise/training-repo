package com.revature.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="customers")
@Data
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id")
	private int id;
	
	@Column(name="c_name")
    private String name;
	
	@Column(name="c_email")
    private String email;
	
	@Column(name="c_address")
    private String address;
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public Customer(int id, String name, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
}
