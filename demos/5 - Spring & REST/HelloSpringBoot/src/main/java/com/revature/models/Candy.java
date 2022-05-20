package com.revature.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="candies")
@Data
public class Candy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private int id;
	
	@Column(name="c_name", unique=true, nullable=false)
	private String name;
	
	@Column(name="c_price", nullable=false)
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_shop", referencedColumnName = "s_id")
	private Shop shop;
	
	public Candy() {}

	public Candy(String name, double price, Shop shop) {
		super();
		this.name = name;
		this.price = price;
		this.shop = shop;
	}

	public Candy(int id, String name, double price, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.shop = shop;
	}
}
