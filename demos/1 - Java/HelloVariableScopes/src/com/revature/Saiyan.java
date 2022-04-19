package com.revature;

public class Saiyan {
	//characterstics aka fields
	//naming convention = camelcase (lowercase first word, capitilize all other words afterwards)
	// private = accessible within that class
	// default = accessible within the class and its package members
	// public = accessible anywhere
	// protected = accessible to the package and its subclasses
	// private -> protected -> default -> public (least to most accessible)
	String name;
	String move;
	int powerLevel;
	int defenseLevel;
	
	//behavior = methods
	//constructor = special method that is used for initialize objects
	//by default, if we don't make our own constructor, java gives us this one:
	//public Saiyan(){ super(); }
	

	public Saiyan() {
		super();
	}

	public Saiyan(String name, String move, int powerLevel, int defenseLevel) {
		//this keyword = is a reference variable that refers to the current class instance
		//ex. Saiyan goku = new Saiyan("goku", "spirit bomb", 100000, 500000);
		this.name = name;
		this.move = move;
		this.powerLevel = powerLevel;
		this.defenseLevel = defenseLevel;
	}

	//getter & setter are used to have access to our private fields
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public int getDefenseLevel() {
		return defenseLevel;
	}

	public void setDefenseLevel(int defenseLevel) {
		this.defenseLevel = defenseLevel;
	}

	//this method is originally from the Object
	//this @Override is a java annotation
	//annotation holds the metadata for a particular functionality that we are doing in our code
	// annotation = a tag that reps the metadata (additional information which is used by the java compiler) that is attached to a class, method, interface, or variable/field
	
	@Override
	public String toString() {
		return "Saiyan [name=" + name + ", move=" + move + ", powerLevel=" + powerLevel + ", defenseLevel="
				+ defenseLevel + "]";
	}
}
