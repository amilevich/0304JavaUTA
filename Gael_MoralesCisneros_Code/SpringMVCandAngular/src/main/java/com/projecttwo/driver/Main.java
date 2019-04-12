package com.projecttwo.driver;

import com.projecttwo.model.Doctor;
import com.projecttwo.model.Patient;
import com.projecttwo.repository.DoctorDao;
import com.projecttwo.repository.PatientDao;

public class Main {

	public static DoctorDao dDao = new DoctorDao();
	public static PatientDao pDao = new PatientDao();

	public static void main(String[] args) {

//		List<Doctor> docs = new ArrayList<>();
//		List<Patient> patients = new ArrayList<>();
//		List<Specialty> specialties = new ArrayList<>();
//		List<Condition> conditions = new ArrayList<>();
//		List<Procedure> procedures = new ArrayList<>();
//		List<Insurance> insurances = new ArrayList<>();
//		Set<Appointment> appointments = new HashSet<>();

		Patient patient1 = new Patient("Lionel", "Richie", "username", "password");
		Doctor doc1 = new Doctor("dDao","emergency","Gene","Dao","d9d7f9e");

		pDao.insert(patient1);
		dDao.insert(doc1);
		
		System.out.println(doc1);
		System.out.println(patient1);

	}

}
