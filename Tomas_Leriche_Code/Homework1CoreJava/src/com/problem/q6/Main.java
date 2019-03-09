package com.problem.q6;

public class Main {
	static void even(int n) {
		//pretty standard
		if ((n / 2) * 2 == n)
			System.out.println("Integer is Even");
		else
			System.out.println("Integer is Odd");
	}
	public static void main(String[] args) {
		even(5);
		even(66);
		even(1);
	}

}
