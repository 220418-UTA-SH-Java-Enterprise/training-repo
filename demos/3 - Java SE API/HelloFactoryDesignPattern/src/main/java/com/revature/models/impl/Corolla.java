package com.revature.models.impl;

import com.revature.models.Automobile;

public class Corolla implements Automobile{

	@Override
	public void drive() {
		System.out.println("Driving the Corolla down the road.");
	}
}
