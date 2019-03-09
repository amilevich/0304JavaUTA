package com.homework.Q19;

import java.util.ArrayList;

public class Q19 {
	public static void main(String[] args) {
		
		ArrayList<Integer> AL = new ArrayList<>();
		
		int Even=0;
		int Odd=0;
		
		
		for(int T=1; T<=10; T++) {
			AL.add(T);
			if (T%2==0) {
				Even = Even+T;
			}
			else {
				Odd = Odd+T;
			}
		}
		
		for(int T=0; T<AL.size();T++) {
			System.out.println(AL.get(T));
		}
		
		System.out.println("Total for even numbers is " + Even);
		System.out.println("Total for odd number is " + Odd);
		
		// Loop up Array length
		for(int N = AL.size() ; N>1; N--) {
			
			// Key for Prime confirming
			char Key = 'P';
			
			int P=N;
			
			// Loop to confirm if prime
			do {
				
				P--;
				// check for 1 or 2
				if(N==1 || N==2) {
					AL.remove(N-1);
					
				}
				// If P Decreases to 1  without the key changing the number is prime
				else if(Key == 'P' && P == 1){
					AL.remove(N-1);
				}
				
				// If P goes in to N evenly the # is not prime
				else if(N%P==0) {
					P = 0;
					Key = 'N';
				}
				
				
			}while(P>1);
		
		}
		
		
		for(int T=0; T<AL.size();T++) {
			System.out.println(AL.get(T));
		}
	}

}
