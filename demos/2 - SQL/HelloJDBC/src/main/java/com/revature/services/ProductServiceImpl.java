package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Product;
import com.revature.repositories.ProductDAO;
import com.revature.repositories.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	private ProductDAO productDao = new ProductDAOImpl();

	@Override
	public boolean addNewProduct(Product p) {
		logger.info("In service layer - sending new product request...");
		return productDao.insert(p);
	}

	@Override
	public boolean editProduct(Product p) {
		logger.info("In service layer - editing existing product...");
		return productDao.update(p);
	}

	@Override
	public Product getProductById(int id) {
		logger.info("In service layer - getting product by id " + id + "...");
		return productDao.findById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		logger.info("In service layer - retrieving all products...");
		return productDao.findAll();
	}

	@Override
	public boolean login(String username, String password) {
		Employee emp = productDao.findByLastName(username);
		
		if(emp == null) {
			logger.error("user is not found in db");
			return false;
		}
		
		//check if username/password from user matches db info
		if(emp.getEmployeeLastName().equals(username) && emp.getEmployeeFirstName().equals(password)) {
			logger.info("valid user. credentials match.");
			return true;
		} else {
			//credentials didn't match
			logger.error("credentials do not match database info for this employee");
			return false;
		}
	}

}
