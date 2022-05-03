package com.revature.drivers;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.Product;
import com.revature.services.ProductService;
import com.revature.services.ProductServiceImpl;

public class MainDriver {
	private static Logger logger = Logger.getLogger(MainDriver.class);
	private static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {
		welcomeScreen();
	}

	public static void welcomeScreen() {
		Scanner scanner = new Scanner(System.in);
		
		logger.info("Starting application. Loading welcome screen...");
		System.out.println("Welcome using to JDBC Demo!");
		System.out.println("Select an option from below:");
		System.out.println("1 - Add new product");
		System.out.println("2 - Get product by id");
		System.out.println("3 - Get all products");
		System.out.println("4 - Update a product");
		System.out.println("5 - Login employee");
		System.out.println("0 - Exit app");
		System.out.println("\nSelection: ");
		
		int userPick = Integer.parseInt(scanner.nextLine());
		
		switch (userPick) {
		case 1:
			logger.info("In driver class: User chose option 1 (add new product)...");
			Product target = new Product();
			
			//get info from user
			System.out.println("Please provide a name for this new product: ");
			String name = scanner.nextLine();
			
			System.out.println("Please provide a price for this new product: ");
			double price = Double.parseDouble(scanner.nextLine());
			
			System.out.println("Please provide an expiration date for this new product (format: YYYY-MM-DD): ");
			String expDateString = scanner.nextLine();
			LocalDate exp_date = LocalDate.parse(expDateString);
			
			target.setProductId(0);
			target.setProductName(name);
			target.setProductPrice(price);
			target.setProductExpDate(exp_date);
			
			//call your service method
			productService.addNewProduct(target);
			break;
		case 2:
			logger.info("In driver class: User chose option 2 (get product by id)...");
			System.out.println("Please enter the id number: ");
			int id = scanner.nextInt();
			
			//call service method
			Product product = productService.getProductById(id);
			
			// print table headers
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			System.out.printf("| %-20s %-20s %-20s %-20s |", "PRODUCT_ID", "NAME", "PRICE", "EXPIRATION_DATE");
			System.out.println();
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			// print table content
			System.out.printf("| %-20s %-20s $%.2f \t\t%-21s |", product.getProductId(), product.getProductName(),
					product.getProductPrice(), product.getProductExpDate());
			System.out.println();
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			break;
		case 3:
			logger.info("In driver class: User chose option 3 (get all products)...");
			List<Product> list = productService.getAllProducts();
			
			// print table headers
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			System.out.printf("| %-20s %-20s %-20s %-20s |", "PRODUCT_ID", "NAME", "PRICE", "EXPIRATION_DATE");
			System.out.println();
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			for (int i = 0; i < list.size(); i++) {
				// print table content
				System.out.printf("| %-20s %-20s $%.2f \t\t%-21s |", list.get(i).getProductId(), list.get(i).getProductName(),
						list.get(i).getProductPrice(), list.get(i).getProductExpDate());
				System.out.println();
			}
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			break;
		case 4:
			logger.info("In driver class: User chose option 4 (update product)...");
			//show list of products
			List<Product> products = productService.getAllProducts();
			
			// print table headers
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			System.out.printf("| %-20s %-20s %-20s %-20s |", "PRODUCT_ID", "NAME", "PRICE", "EXPIRATION_DATE");
			System.out.println();
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			for (int i = 0; i < products.size(); i++) {
				// print table content
				System.out.printf("| %-20s %-20s $%.2f \t\t%-21s |", products.get(i).getProductId(), products.get(i).getProductName(),
						products.get(i).getProductPrice(), products.get(i).getProductExpDate());
				System.out.println();
			}
			System.out.println(
					"+-------------------------------------------------------------------------------------+");
			System.out.println("");
			System.out.println("Please enter the id number of the product that you want to edit: ");
			int targetId = scanner.nextInt();
			
			//call service method
			Product targetProduct = productService.getProductById(targetId);
			System.out.println("Old Product Info: ");
			System.out.println("Product ID: " + targetProduct.getProductId());
			System.out.println("Product Name: " + targetProduct.getProductName());
			System.out.println("Product Price: " + targetProduct.getProductPrice());
			System.out.println("Product Expiration Date: " + targetProduct.getProductExpDate());
			
			System.out.println("Edit Product");
			System.out.println("Instructions: Type new data into corresponding prompt. Type old info in to keep old info for this product. ");
			
			Product newProduct = new Product();
			System.out.println("Please enter a new product name: ");
			String newName = scanner.next();
			
			System.out.println("Please enter a new product price: ");
			double newPrice = scanner.nextDouble();
			
			System.out.println("Please enter a new product expiration date: ");
			String newExpDateString = scanner.next();
			LocalDate new_exp_date = LocalDate.parse(newExpDateString);
			
			newProduct.setProductId(targetId);
			newProduct.setProductName(newName);
			newProduct.setProductPrice(newPrice);
			newProduct.setProductExpDate(new_exp_date);
			
			System.out.println("New Product Info: ");
			System.out.println("Product ID: " + newProduct.getProductId());
			System.out.println("Product Name: " + newProduct.getProductName());
			System.out.println("Product Price: " + newProduct.getProductPrice());
			System.out.println("Product Expiration Date: " + newProduct.getProductExpDate());
			
			System.out.println("Would you like to apply these changes [Y/N]?");
			char answer = Character.toUpperCase(scanner.next().charAt(0));
			
			if(answer == 'Y') {
				productService.editProduct(newProduct);
			}else {
				System.out.println("Changes aborted by user. Exiting app. Goodbye!");
			}
			
			break;
		case 5:
			logger.info("In driver class: User chose option 5 (login employee)");
			//prompt user to enter information
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your username (lastname):");
			String username = sc.nextLine();
			
			System.out.println("Please enter your password (firstname):");
			String password = sc.nextLine();
			
			boolean checkCredentials = productService.login(username, password);
			if(checkCredentials == true) {
				System.out.println("Successful login");
			}else {
				System.out.println("Invalid username and/or password. Please try again.");
			}
			break;
		case 0:
			logger.info("In driver class: User chose option 0 (close app)...");
			System.out.println("Exiting app. Goodbye!");
			//close the scanner
			scanner.close();
			//close the app
			System.exit(0);
			break;
		default:
			logger.info("In driver class: User chose an invalid option...");
			System.out.println("Invalid option. Try again.");
			welcomeScreen();
			break;
		}
	}
}
