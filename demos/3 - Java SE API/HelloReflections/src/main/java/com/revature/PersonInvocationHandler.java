package com.revature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.azhya.Person;

/**
 * This is a Dynamic Proxy Design Pattern. A proxy is an "add-on" to a class,
 * that allows us to intercept method invocation and modify runtime behavior
 * 
 *  * Great resource: https://codegym.cc/groups/posts/208-dynamic-proxies
 */
public class PersonInvocationHandler implements InvocationHandler {

	/*
	 * What is this? InvocationHandler interface from java.lang.reflect
	 * 
	 * InvocationHandler is a special interface that lets us intercept any method
	 * call to our object and add the additional behavior we need.
	 * 
	 * We need to create our own interceptor (that's what PersonInvocationHandler
	 * is...it's a class that implements the InvocationHandler Interface.
	 * 
	 * We will need to pass an instantiation of this class into the
	 * Proxy.newProxyInstance() constructor in order to make a proxy object.
	 */

	// declare the INTERFACE that we're overriding We can only use invocationHandlers with Interfaces.
	private Person person;
	
	// a constructor for the proxy object
	public PersonInvocationHandler(Person person) {
		super();
		this.person = person;
	}
	
	// Using this method, we can modify the behavior of a class using reflection
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// here we're adding extra functionality (a message) and still invoking the
		// original method.
		System.out.println("Hello!");

		return method.invoke(person, args);
		// the invoke() method has access to the originally invoked method and all its
		// arguments
	}

}
