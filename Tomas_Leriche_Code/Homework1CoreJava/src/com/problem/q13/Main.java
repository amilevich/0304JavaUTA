package com.problem.q13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		triangle();
	}

	// for printing strings
	public static void loopPrint(Deque<String> dstring) {

		for (String elem : dstring) {
			System.out.print(elem);
		}
	}

	// printing and logic for 10s
	public static void triangle() {
		int x = 0;
		// Using a Deque
		Deque<String> alist = new ArrayDeque<String>();
		alist.add("0");
		// only need to print 4 lines
		while (x < 4) {
			// could have used a switch but didn't
			for (String elem : alist) {

				// print loop method to string as strings without brackets
				// then skip a space.
				loopPrint(alist);
				System.out.println("\n");

				// each length is checked and element added to
				// either side depending on what is needed.
				if (alist.size() == 1) {
					alist.addFirst("1");
					break;
				}
				if (alist.size() == 2) {
					alist.addLast("1");
					break;
				}
				if (alist.size() == 3) {
					alist.addFirst("0");
					break;
				}
				break;
			}
			x++;
		}
	}
}
