package com.example.sorting;

import java.time.LocalDate;
import java.util.Comparator;

public class StudentDobComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		LocalDate o1Dob = o1.getDob();
		LocalDate o2Dob = o2.getDob();

		if (o1Dob.isBefore(o2Dob)) {
			return 1;
		} else if (o1Dob.isAfter(o2Dob)) {
			return -1;
		} else {
			return 0;
		}
	}

}
