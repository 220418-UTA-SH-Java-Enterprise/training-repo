package com.revature.example;

//this class will serve as an example of using the Comparator interface
public class Car implements Comparable<Car>{

	private int id;
	private int year;
	private String name;
	private String model;
	
	@Override
	public int compareTo(Car o) {
		// compare year numbers
		return this.year - o.year;
	}

	public Car(int id, int year, String name, String model) {
		super();
		this.year = year;
		this.name = name;
		this.model = model;
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car [year=" + year + ", name=" + name + ", model=" + model + ", id="+ id +"]";
	}
}
