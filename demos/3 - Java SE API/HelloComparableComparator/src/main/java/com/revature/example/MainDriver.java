package com.revature.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDriver {

	public static void main(String[] args) {
		List<Book> wishlist = new ArrayList<>();
		
		wishlist.add(new Book(3.5, "Red Fish, Blue Fish", "Dr. Seuss", 1989, 6.99));
		wishlist.add(new Book(1.5, "Really bad book", "Bad Author", 1943, 1000.50));
		wishlist.add(new Book(2.3, "Romeo & Juliet", "William Shakespeare", 1698, 0.99));
		wishlist.add(new Book(4.5, "Lord of the Rings", "J.R. Tolkien", 1988, 14.99));
		wishlist.add(new Book(5.0, "Harry Potter and the Chamber of the Secrets", "J.K. Rowling", 1997, 12.47));
		
		//sort the list
		Collections.sort(wishlist);
		
		for(Book item: wishlist) {
			System.out.println(item);
		}
		
		System.out.println("------------------------");
		List<Car> dealershipList = new ArrayList<>();
		dealershipList.add(new Car(1, 1999, "Fiesta", "Ford"));
		dealershipList.add(new Car(2, 2015, "F-150", "Ford"));
		dealershipList.add(new Car(3, 2009, "Camry", "Toyota"));
		dealershipList.add(new Car(4, 2022, "Maxium", "Nissan"));
		
		IdCompare idCompare = new IdCompare();
		
		//uses Comparator to sort by id instead of year
		//With Comparator, sorting is through a separate class
		//and it compares based on the condition provided by the developer rather than natural order
		Collections.sort(dealershipList, idCompare);
		
		//With Comparable, it is meant for objects with natural ordering (aka the object itself must know how it is ordered).
		//Collections.sort(dealershipList);
		
		for(Car car: dealershipList) {
			System.out.println(car);
		}
	}

}
