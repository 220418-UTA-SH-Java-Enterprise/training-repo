package com.revature.drivers;

import com.revature.factory.ToyotaAutomobileFactory;
import com.revature.models.Automobile;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// create an ToyotaAutomobileFactory object to make some automobiles
		ToyotaAutomobileFactory automobileFactory = new ToyotaAutomobileFactory();

		// get an object of Corolla and call its drive method.
		Automobile automobile1 = automobileFactory.getAutomobile("COROLLA");

		// call drive method of Corolla
		automobile1.drive();

		// get an object of Camry and call its drive method.
		Automobile automobile2 = automobileFactory.getAutomobile("CAMRY");

		// call drive method of Camry
		automobile2.drive();

		// get an object of Highlander and call its drive method.
		Automobile automobile3 = automobileFactory.getAutomobile("HIGHLANDER");

		// call drive method of Highlander
		automobile3.drive();

	}

}
