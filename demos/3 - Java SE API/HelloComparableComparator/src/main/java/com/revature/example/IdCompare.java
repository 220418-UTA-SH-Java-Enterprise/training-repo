package com.revature.example;

import java.util.Comparator;

//this class is to compare cars by name
public class IdCompare implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		//comparing the values of these two numbers in order to properly sort the collection elements
		//if numerically o1 comes before o2, not of the same value -> false
		//-1, object 1 needs to come first
		if(o1.getId() < o2.getId()) return -1;
		
		//if numerically o1 is the same as o2, are of the same value -> true
		//1, object 2 needs to come first
		if(o1.getId() > o2.getId()) return 1;
		
		//else not change is needed in order -> do nothing
		else return 0;
	}

}
