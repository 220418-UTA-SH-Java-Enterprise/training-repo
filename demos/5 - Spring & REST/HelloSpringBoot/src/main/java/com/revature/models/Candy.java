package com.revature.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="candies")
@Data
@ApiModel(value = "Candy", description = "This model serves as basic model for all candy entity API operations")
public class Candy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	@ApiModelProperty(name="id", 
	notes="an Integer value that serves as the unique identier for any candy entity",
	required = true,
	value = "1")
	private int id;
	
	@Column(name="c_name", unique=true, nullable=false)
	@ApiModelProperty(name="name", 
	notes="a String value that serves as the name of the candy",
	required = true,
	value = "test candy name")
	private String name;
	
	@Column(name="c_price", nullable=false)
	@ApiModelProperty(name="price", 
	notes="a Double value that serves as the current selling price of the given candy",
	required = true,
	value = "3.89")
	private double price;
	
	//no apimodelproperty annotation needed here -> values already set in Shop model fields
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
