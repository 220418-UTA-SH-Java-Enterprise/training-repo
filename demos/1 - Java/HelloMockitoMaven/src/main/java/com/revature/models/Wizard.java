package com.revature.models;

public class Wizard {
	
	int id;
	String name;
	String spell;
	
	public Wizard() {
		super();
	}

	public Wizard(int id, String name, String spell) {
		super();
		this.id = id;
		this.name = name;
		this.spell = spell;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	@Override
	public String toString() {
		return "Wizard [id=" + id + ", name=" + name + ", spell=" + spell + "]";
	}
}
