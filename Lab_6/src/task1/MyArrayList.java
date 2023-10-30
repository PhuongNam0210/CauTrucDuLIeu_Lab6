package task1;

import java.util.Arrays;
import java.util.Comparator;

import task2.MyLinkedList;
import task2.MyLinkedList.SinglyLinkedList;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (size == elements.length) {
			E[] newElements = (E[]) new Object[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
//		E replacedElement = elements[i];
		elements[i] = e;
		return elements[i];
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (size == elements.length) {
			growSize();
		}

		System.arraycopy(elements, i, elements, i + 1, size - i);
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E removedElement = elements[i];
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);
		elements[--size] = null;
		return removedElement;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		System.arraycopy(elements, 0, array, 0, size);
		return array;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> a = new MyArrayList<Integer>();
		a.add(1);
		a.add(5);
		a.add(10);
		a.add(15);
		a.add(20);
		
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		System.out.println(a.add(5));
		System.out.println(a.lastIndexOf(a));
		System.out.println(a.remove(3));
		System.out.println(a.contains(15));
		System.out.println(a.indexOf(10));


	}

}