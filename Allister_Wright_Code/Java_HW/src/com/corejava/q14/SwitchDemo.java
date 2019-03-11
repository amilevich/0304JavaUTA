package com.corejava.q14;

import java.time.Instant;
import java.util.Arrays;

public class SwitchDemo
{

	public static void main(String[] args)
	{

		// Iterate over test cases
		for (int i = 1; i < 4; i++)
			testSwitch(i);

	}

	static void testSwitch(int idx)
	{
		switch (idx)
		{
		case 1:
			// Call Math.sqrt(); print the result
			System.out.println(Math.sqrt(16));
			break;
		case 2:
			// Get current UTC time from system clock
			String isoDateTime = Instant.now().toString();
			// Discard everything after the marker for the current time
			String today = isoDateTime.split("T")[0];
			// Display the date
			System.out.println(today);
			break;
		case 3:
			// Initialise target String
			String initStr = "I am learning Core Java";
			// Split and store in String array
			String[] splitStr = initStr.split(" ");
			// Display the array
			System.out.println(Arrays.toString(splitStr));
			break;
		}
	}
}
