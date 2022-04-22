package com.revature.custom_collections;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
	//fields
	protected int size;
	protected Object[] elements;
	
	//constructors
	public MyArrayList() {
		elements = new Object[16];
	}
	
	public MyArrayList(int intitialCapacity) {
		elements = new Object[intitialCapacity];
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param element = the element to be appended to this list
	 * @return true
	 **/
	@Override
	public boolean add(T element) {
		elements[size] = element;
		size++;
		resizeBackingArrayIfNeeded();
		return true;
	}

	/**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
	@Override
	public boolean contains(T element) {
		for(int i = 0; i < size; i++) {
			if(elements[i] == null) {
				if(element == null) {
					return true;
				}
			}else if(elements[i].equals(element)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	 /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the
     * element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists). Returns true if this list contained the specified element.
     *
     * @param element element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
	@Override
	public boolean remove(T element) {
		for (int i = 0; i < size; i++) {
			if((elements[i] == null && element == null) || (elements[i] != null && elements[i].equals(element))) {
				removeAtIndex(i);
				size--;
				return true;
			}
		}
		return false;
	}

	/**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
	@Override
	public int size() {
		return size;
	}

	/**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
	@Override
	@SuppressWarnings({"unchecked"})
	public T get(int index) {
		if(notInRange(index)) {
			throw new IndexOutOfBoundsException();
		}
		return (T) elements[index];
	}

	/**
     * Inserts the specified element at the specified position in this list. Shifts
     * the element currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
	@Override
	public void add(int index, T element) {
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		Object[] newElements = resizeWillBeNeeded(size + 1) ? new Object[nextSize()] : new Object[elements.length];
		System.arraycopy(elements, 0, newElements, 0, index);
		System.arraycopy(elements, index, newElements, index + 1, elements.length - index - 1);
		newElements[index] = element;
		size++;
		elements = newElements;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

}
