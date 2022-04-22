package com.revature.custom_collections;

public interface MyList<T> extends MyCollection<T>{
	T get(int index);
	void add(int index, T element);
	T set(int index, T element);
	int indexOf(T element);
	int lastIndexOf(T element);
}
