package com.example.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListExample {

	public static void main(String[] args) {
		
		// ArrayList
		
		ArrayList<Integer> aList = new ArrayList<>();
		List<Integer> arrayList = new ArrayList<>();
		// ArrayList inherits from List
		
		arrayList.add(3);
		arrayList.add(42);
		arrayList.add(2);
		arrayList.add(33);
		arrayList.add(8);
		arrayList.add(170);
		
		// print out the whole arraylist
		//System.out.println(arrayList);
		//print out a specific index, 3rd element
		//System.out.println(arrayList.get(2));

		//System.out.println(arrayList.get(10));
		// IndexOutOfBounds Exception
		
		
		// Iterators
		ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());
		
		while (listIterator.hasPrevious()) { ///.hasPrevious prints it backwards
			//.hasNext prints out forwards
			System.out.println(listIterator.previous() + " ");
		}
	}
	
	//Linked List
	LinkedList<Integer> lList = new LinkedList<>();
	// in a linked list, we have a collection of "nodes"
	// where each node points to the previous and next
	// node
}
