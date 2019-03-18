package com.project.model;

// PURPOSE: counter class will keep track of account ID
// meaning it holds a number, and that number is incremented
// every time a new user registers. It will not go down
// starts at one, and if customer with account ID one is 
// deleted then one will never be used again, but each
// customer is guranteed to have a unique ID. 

public class Counter {

	int holdLastUsedID; 
	
	public Counter()
	{
		
	}
	
	public Counter (int holdLastUsedID)
	{
		super(); 
		this.holdLastUsedID = holdLastUsedID; 
	}

	public int getHoldLastUsedID() {
		return holdLastUsedID;
	}

	public void setHoldLastUsedID(int holdLastUsedID) {
		this.holdLastUsedID = holdLastUsedID;
	}
	
	
}
