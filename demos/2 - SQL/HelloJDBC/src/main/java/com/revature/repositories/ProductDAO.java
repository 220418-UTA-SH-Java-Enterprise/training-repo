package com.revature.repositories;

import java.util.List;

import com.revature.models.Product;

public interface ProductDAO {
	
	/*interfaces by default are public in java*/
	public boolean insert(Product p);
	public boolean update(Product p);
	public Product findById(int id);
	public List<Product> findAll();

}
