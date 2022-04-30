package com.revature.models.impl;

import com.revature.models.Automobile;

public class Highlander implements Automobile{

	@Override
	public void drive() {
		System.out.println("Driving the Highlander down the road.");
	}
}
