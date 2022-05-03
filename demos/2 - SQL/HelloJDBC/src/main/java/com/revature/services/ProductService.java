package com.revature.services;

import java.util.List;

import com.revature.models.Product;

public interface ProductService {

	public boolean addNewProduct(Product p);
	public boolean editProduct(Product p);
	public Product getProductById(int id);
	public List<Product> getAllProducts();
	public boolean login(String username, String password);
}
