package com.homework.q08;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<String>();		//creates Arraylist for all words
        words.add("karan");
        words.add("madam");
        words.add("tom");
        words.add("civic");
        words.add("radar");
        words.add("sexes");
        words.add("jimmy");
        words.add("kayak");
        words.add("john");
        words.add("refer");
        words.add("billy");
        words.add("did");
        
        ArrayList<String> palindromes = new ArrayList<String>();	//creates Arraylist for all palindromes(empty right now)

        for (int i = 0; i < words.size(); i++) {	
            String b = "";									//method turns each string to array
            int n = words.get(i).length();			
            for(int x = n - 1; x >= 0; x--)					//method reverses each string
                {
                    b = b + words.get(i).charAt(x);
                }
                if(words.get(i).equalsIgnoreCase(b))		//finds if reverse string equal to string
                {
                    palindromes.add(words.get(i));			//puts into palindromes ArrayList
                }
        }
        System.out.println(words);
        System.out.println("These are palindromes: " + palindromes);
    }
    

}