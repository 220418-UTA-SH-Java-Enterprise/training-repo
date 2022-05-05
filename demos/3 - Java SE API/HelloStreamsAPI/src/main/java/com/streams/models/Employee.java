package com.streams.models;

import java.util.Objects;

//simple POJO
public class Employee implements Comparable<Employee>{
	
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		//returns the hashing value of an object 
		//this value's purpose is to faciliate hashing in hash tables or other hashing data structures
		//ex. HashMap
		//TODO: look into hash functions in Java, teriary operator
		
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
		
		//this code above is the same as:
		//return Objects.hash(age, name);
	}

	@Override
	//this is used to compare objects
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Employee o) {
		if(this.name.equalsIgnoreCase(o.name)) {
			return 1;
		}
		
		return 0;
	}
	
	
}
