package com.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {

		// HashMap
		// unique keys
		
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(4, "Kenny The Bird");
		hashMap.put(6, "Billy The Pig");
		hashMap.put(7, "Timmy The Tortoise");
		hashMap.put(4, "Rebecca The Platypus");
		
		hashMap.put(null, "Jack The Spider");
		// null can be a key
		// keys must be unique
		// keys are objects
		
		hashMap.size();
		//System.out.println(hashMap.get(4));
		//System.out.println(hashMap.get(99)); //null
		//System.out.println(hashMap);
		
		// Loop
		for (Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

}
