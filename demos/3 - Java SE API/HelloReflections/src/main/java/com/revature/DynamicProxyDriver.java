package com.revature;

import java.lang.reflect.Proxy;
import java.util.Scanner;

//we can import classes/ methods and interfaces from another project
import com.azhya.Person;
import com.azhya.Saiyan;

/**
 * Reflection API is used to examine or modify the behavior of
 * classes/methods/interfaces at runtime.
 * 
 * It comes from the Java.lang.reflect package
 * 
 * https://www.geeksforgeeks.org/reflection-in-java/
 */
public class DynamicProxyDriver {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Saiyan s1 = new Saiyan("Goku", 3000, "Japan", "Earth");
		
		/**
		 * I want to modify the method at runtime But I can't because it's not my code
		 * (it's from an external framework)
		 */
		s1.introduce();
		
		/**
		 * Reflection API is used to examine or modify the behavior of
		 * classes/methods/interfaces at runtime.
		 * 
		 * So that I can change the runtime behavior of interfaces and their class
		 * implementations!
		 */

		// Get a ClassLoader from the original object that we want to create a proxy for
		ClassLoader s1ClassLoader = s1.getClass().getClassLoader();
		
		// capture all the interfaces that the original object implements
		Class[] interfaces = s1.getClass().getInterfaces();

		// Create a proxy for our Adult obj
		Person proxyS1 = (Person) Proxy.newProxyInstance(s1ClassLoader, interfaces, new PersonInvocationHandler(s1));
		
		/*
		 * What is a Proxy?
		 * 
		 * Proxy is a design pattern. We create and use proxy objects when we want to
		 * add or modify some functionality of an already existing class. The proxy
		 * object is used instead of the original one.
		 * 
		 * Usually, the proxy objects have the same methods as the original one and in
		 * Java, proxy classes usually extend the original class. The proxy has a handle
		 * to the original object and can call the method on that. (InvocationHandler)
		 */
		
		// Call method we have modified in Person Invocation Handler!
		proxyS1.introduce();

		/**
		 * EXTRA: (just messing around)
		 * What if we wanted to select whether we'd call the Dynamic Proxy behavior or
		 * the original method's behavior?
		 * 
		 * Below would be kind of silly...
		 */
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a method for Goku the object to do (either introduce or sayPower)!");
		String method = scan.next();

		if (method.equals("introduce")) {

			// call from proxy with intercepted metho behavior
			proxyS1.sayPower();

		} else if (method.equals("sayPower")) {
			// call from the original Class's method behavior (without hello)
			s1.sayPower();
		}

		/**
		 * We can use INSPECTION to create a method that prints
		 * all the methods that belong to the Adult class
		 */
		ClassInspector.listDeclaredMethods(Saiyan.class);
		
		//close scanner to avoid memory leaks
		scan.close();
	}

}
