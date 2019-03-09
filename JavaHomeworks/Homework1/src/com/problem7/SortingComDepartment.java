package com.problem7;

import java.util.Comparator;

public class SortingComDepartment implements Comparator <Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getDepartment().compareTo(o2.getDepartment())>0) {
			return 1;
		} else if (o1.getDepartment().compareTo(o2.getDepartment())<0) {
			return -1;
		} else { 
			return 0;
		}
		
		}
	}
	


