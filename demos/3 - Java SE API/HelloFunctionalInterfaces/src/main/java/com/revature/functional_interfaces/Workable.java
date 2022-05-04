package com.revature.functional_interfaces;

/*
 * So in order to make an interface as a functional interface, we will need to use
 * the @FunctionalInterface annotation. 
 */
@FunctionalInterface
public interface Workable {
	//remember, by default methods in interfaces are public, abstract, and static 
	public void doFirstWork();
}
