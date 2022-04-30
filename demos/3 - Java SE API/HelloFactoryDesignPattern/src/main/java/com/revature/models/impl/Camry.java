package com.revature.models.impl;

import com.revature.models.Automobile;

public class Camry implements Automobile{

	@Override
	public void drive() {
		System.out.println("Driving the Camry down the road.");
	}
}
