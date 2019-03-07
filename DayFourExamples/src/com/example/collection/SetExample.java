package com.example.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {

		//Sets
		
		//Hash Set
		// sets do not guarantee insertion order
		
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(4);
		hashSet.add(4);
		hashSet.add(18);
		hashSet.add(16);
		hashSet.add(52);
		
		System.out.println(hashSet);
		System.out.println(hashSet.size());
		
		
		// TreeSet
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		System.out.println(treeSet);
		// prints out in order, it is sorted
	}

}
