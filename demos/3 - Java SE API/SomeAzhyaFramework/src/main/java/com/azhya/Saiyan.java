package com.azhya;

/*
 * This framework is to simulate how you can include this 
 * as a Maven dependency in another Java project.
 * 
 * Here, all I will be using a simple interface and POJO object, 
 * and be able to use them in another project (similar to what you will
 * be doing in your P1).
 */
public class Saiyan implements Person{

	private String name;
	private int power;
	private String country;
	private String planet;
	
	public Saiyan(String name, int power, String country, String planet) {
		super();
		this.name = name;
		this.power = power;
		this.country = country;
		this.planet = planet;
	}

	public void introduce() {
		System.out.println("Hi, my name is " + this.name + ".");
	}

	public void sayPower() {
		System.out.println("My power level is at " + this.power);
	}

	public void sayWhereFrom() {
		System.out.println("I'm from " + this.country + " on planet " + this.planet + ".");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planet == null) ? 0 : planet.hashCode());
		result = prime * result + power;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saiyan other = (Saiyan) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (planet == null) {
			if (other.planet != null)
				return false;
		} else if (!planet.equals(other.planet))
			return false;
		if (power != other.power)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Saiyan [name=" + name + ", power=" + power + ", country=" + country + ", planet=" + planet + "]";
	}
}
