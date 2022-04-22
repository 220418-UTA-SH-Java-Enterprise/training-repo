package com.revature.custom_collections;

public class CustomArrayListExample {

	public static void main(String[] args) {
		MyArrayList<String> brands = new MyArrayList<>();
		brands.add("Nike");
		brands.add("Pepsi");
		brands.add("Kellogs");
		brands.add("Nintendo");
		brands.add("LA Gear");
		brands.add("Under Armor");
		
		for(int i = 0; i < brands.size; i++) {
			System.out.println(brands.get(i));
		}
	}

}
