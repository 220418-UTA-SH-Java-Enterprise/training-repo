package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shops")
@Data
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="s_id")
	private int id;
	
	@Column(name="s_name", unique=true, nullable=false)
	private String shopName;
	
	@Column(name="s_inventory_count", nullable=false)
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
