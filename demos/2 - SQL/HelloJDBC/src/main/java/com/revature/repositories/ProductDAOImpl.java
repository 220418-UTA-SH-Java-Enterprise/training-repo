package com.revature.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.models.Product;
import com.revature.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {

	private static Logger logger = Logger.getLogger(ProductDAOImpl.class);
	private static DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public boolean insert(Product p) {
		logger.debug("Product: " + p);

		// 1. create a connection using my ConnectionUtil class - try-with-resources
		try (Connection conn = ConnectionUtil.getConnection()) {
			logger.info("In DAO layer: making a new product in db...");
			// 2. prepare my SQL statement using JDBC's PreparedStatement
			// this string represents the SQL code which we will execute in our DB
			// We use ?'s as placeholders which we can insert values from Java using
			// PreparedStatements
			// we do this to avoid something that is called "SQL Injection" (security
			// concept as which end-users can put in malicious data using your own code)
			String sql = "insert into products (name, price, expiration_date) values (?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getProductName());
			stmt.setDouble(2, p.getProductPrice());
			stmt.setDate(3, Date.valueOf(p.getProductExpDate()));

			// 3. executing that query
			stmt.executeUpdate();

			logger.info("New product has been successfully created.");

			// 4. close db connection to avoid memory leaks
			conn.close();
		} catch (SQLException e) {
			logger.warn("Unable to execute SQL statement", e);
			return false;
		}

		// 4. return true if insert was successful in db
		return true;
	}

	@Override
	public boolean update(Product p) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			// now updating users table
			String sql = "UPDATE products SET name = ?, price = ?, expiration_date = ? WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getProductName());
			stmt.setDouble(2, p.getProductPrice());
			stmt.setDate(3, Date.valueOf(p.getProductExpDate()));
			stmt.setInt(4, p.getProductId());
			stmt.executeUpdate();

			logger.info("Product update for ID " + p.getProductId() + " was successful. ");

		} catch (SQLException e) {
			logger.warn("Unable to execute SQL statement", e);
			return false;
		}
		
		return true;
	}

	@Override
	public Product findById(int id) {
		logger.info("In DAO layer: getting product by id...");
		Product product = new Product();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM products WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				product.setProductId(id);
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = rs.getDate(4).toString();
				LocalDate exp_date = LocalDate.parse(date, formatter);
				product.setProductExpDate(exp_date);
			}

			logger.info("Product search by id was successful. " + product);
		} catch (SQLException e) {
			logger.warn("Unable to execute SQL statement", e);
		}
		
		return product;
	}

	@Override
	public List<Product> findAll() {
		logger.info("In DAO layer: getting all products from DB...");
		List<Product> list = new ArrayList<Product>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			// We need to create a String that will pass a SQL command to our database MS
			// The following String represents the SQL that we will execute in our DB:
			String sql = "SELECT * FROM products ORDER BY id ASC;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			/*
			 * ResultSet starts at 1 position behind the starting point of our data...So, in
			 * order to access the first value, we invoke next() to start....
			 */
			while (rs.next()) {
				//1. get information out of the resultSet for each record
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = rs.getDate("expiration_date").toString();
				LocalDate exp_date = LocalDate.parse(date, formatter);

				//2. make a object that matches that record info
				Product p = new Product(id, name, price, exp_date);

				//3. add item into our list
				list.add(p);
			}
			
			int size = 0;
			if (rs != null) 
			{
			  rs.last();    // moves cursor to the last row
			  size = rs.getRow(); // get row id 
			}
			
			logger.info("List has been successfully retrieved. Number of products: " + size);
			//4. close the resultSet
			rs.close();
			
			//5. close connection
			conn.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve products from the database", e);
		}
		
		return list;
	}

	@Override
	public Employee findByLastName(String lastname) {
		logger.info("In DAO layer: getting employee info by id...");
		Employee target = new Employee();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employees WHERE last_name = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastname);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				target.setEmployeeId(rs.getInt("id"));
				target.setEmployeeFirstName(rs.getString("first_name"));
				target.setEmployeeLastName(lastname);
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String birthdate = rs.getDate("birthdate").toString();
				LocalDate birth_date = LocalDate.parse(birthdate, formatter1);
				target.setEmployeeBirthdate(birth_date);
				target.setEmployeeMonthlyIncome(rs.getDouble("monthly_income"));
				Department tempDept = departmentDao.getDepartmentById(rs.getInt("department_id"));
				target.setEmployeeDepartment(tempDept);
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String hiredate = rs.getDate("hire_date").toString();
				LocalDate hire_date = LocalDate.parse(hiredate, formatter2);
				target.setEmployeeHiredate(hire_date);
				target.setEmployeeJobTitle(rs.getString("job_title"));
				target.setEmployeeEmail(rs.getString("email"));
			}

			logger.info("Employee search by lastname was successful. " + target);
		} catch (SQLException e) {
			logger.warn("Unable to execute SQL statement", e);
		}
		
		return target;
	}

}
