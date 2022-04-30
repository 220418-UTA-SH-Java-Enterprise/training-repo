package com.revature.factory;

import com.revature.models.Automobile;
import com.revature.models.impl.*;

public class ToyotaAutomobileFactory {
	// use getAutomobile method to get object of type automobile
	public Automobile getAutomobile(String automobileType) {
		if (automobileType == null) {
			return null;
		}
		if (automobileType.equalsIgnoreCase("COROLLA")) {
			return new Corolla();

		} else if (automobileType.equalsIgnoreCase("CAMRY")) {
			return new Camry();

		} else if (automobileType.equalsIgnoreCase("HIGHLANDER")) {
			return new Highlander();
		}

		return null;
	}
}
