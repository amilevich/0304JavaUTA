package com.example.collection;

import java.util.ArrayList; //import this to use ArrayList
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListExample {
	
	public static void main(String[] args) {
		
		//ArrayList
		ArrayList<Integer> aList = new ArrayList<>(); //the data type inside <> is called a generic
		List<Integer> arrayList = new ArrayList<>(); //ArrayList inherits from List
		
		arrayList.add(3);
		arrayList.add(5);
		arrayList.add(45);
		arrayList.add(21);
		arrayList.add(18);
		
		System.out.println(arrayList); //prints out the whole ArrayList; notice you CANNOT do this with a regular array
		System.out.println(arrayList.get(2)); //prints out the third element in the list
		
		//System.out.println(arrayList.get(10)); //ArrayIndexOutOFBounds
		//IndexOutOfBounds Exception
		
		//Iterators
		ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size()); //ArrayList has size instead of length
		while(listIterator.hasPrevious()) { //.hasPrevious() prints it backwards; .hasNext() prints it forwards
			System.out.println(listIterator.previous() + " ");
		}
		
		//LinkedList
		LinkedList<Integer> lList = new LinkedList<>(); //don't forget to import LinkedList and fill out left <>
		//in a linked list, we have a collection of nodes where each node points to the prevous and next nodes
	}

}
