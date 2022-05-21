package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="shops")
@Data
@ApiModel(value = "Shop", description = "This model serves as basic model for all shop entity API operations")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="s_id")
	@ApiModelProperty(name="id", 
	notes="an Integer value that serves as the unique identier for any shop entity",
	required = true,
	value = "1")
	private int id;
	
	@Column(name="s_name", unique=true, nullable=false)
	@ApiModelProperty(name="shopName", 
	notes="a String value that serves as the shop name",
	required = true,
	value = "test shop name")
	private String shopName;
	
	@Column(name="s_inventory_count", nullable=false)
	@ApiModelProperty(name="inventoryCount", 
	notes="an Integer value that serves as the shop inventory count of candies",
	required = true,
	value = "200")
	private int inventoryCount;
	
	public Shop() {}

	public Shop(String shopName, int inventoryCount) {
		super();
		this.shopName = shopName;
		this.inventoryCount = inventoryCount;
	}

	public Shop(int id, String shopName, int inventoryCount) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.inventoryCount = inventoryCount;
	}
}
