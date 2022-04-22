package com.revature.custom_collections;

/*
 * - Generics are used to provide abstraction by making parameterized types
 * - Through generics, we can create classes that work with different data types
 * 
 * - Commonly generics follow the following parameter type naming convention:
 * E - element
 * T - Type
 * K - Key
 * V - Value
 * N - Number
 * S, U, V, etc - 2nd, 3rd, 4th types
 * ? - wildcard = of any unexpected type
 * 
 * - Benefits of generics:
 *   - more dynamic/flexible code that can take in any sort of data
 *   - more generic programming that can be reusable throughout our applications
 * */

/*
 * - Commonly, wrapper classes are used with generics
 * - A wrapper class is a utility class that provides object-like behavior to a primitive data type.
 * - In other words, "wraps your primitive in a giftbox marked Object"
 * - List:
 * 		- int -> Integer
 * 		- char -> Character
 * 		- bool -> Boolean
 * 		- etc.
 * 
 * ex. ArrayList<Integer> list = new ArrayList<>();
 *(this is an example of autoboxing)
 *- Type casting is the process of assigning a variable of one type to a variable of another type
 *- Autoboxing = when you take a primitive and assign it to a wrapper class object
 *- Unboxing = taking the wrapper class object and converting it into a primitive
 * */
public interface MyCollection<T> {

	boolean add(T element);
	boolean contains(T element);
	boolean isEmpty();
	boolean remove(T element);
	int size();
	
}
