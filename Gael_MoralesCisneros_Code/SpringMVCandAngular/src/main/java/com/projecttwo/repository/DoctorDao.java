package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.util.HibernateUtil;
import com.projecttwo.model.Doctor;

@Repository
public class DoctorDao {
	
	public void insert(Doctor dir) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(dir);
		tx.commit();
		
	}
	
	
	
	public Doctor update(Doctor doctor) {
		try  {
		Session ses = HibernateUtil.getSession();
//		if (ses.isOpen())
//			ses.clear();
	
		Transaction tx = ses.beginTransaction(); 
		
//		Doctor updDoc = new Doctor();
//		updDoc.setDoctorId(doctor.getDoctorId());
//		updDoc.setFirstName(doctor.getFirstName());
//		updDoc.setLastName(doctor.getLastName());
//		updDoc.setUserName(doctor.getUserName());
//		updDoc.setPassWord(doctor.getPassWord());
//		updDoc.setSsN(doctor.getSsN());
//		updDoc.setPhone(doctor.getPhone());
//		updDoc.setEmail(doctor.getEmail());
//		updDoc.setMedicalId(doctor.getMedicalId());
//		updDoc.setGender(doctor.getGender());
//		updDoc.setAffiliation(doctor.getAffiliation());
//		updDoc.setStreet(doctor.getStreet());
//		updDoc.setCity(doctor.getCity());
//		updDoc.setState(doctor.getState());
//		updDoc.setZipcode(doctor.getZipcode());
//		updDoc.setStreet2(doctor.getStreet2());
//		updDoc.setCity2(doctor.getCity2());
//		updDoc.setState2(doctor.getState2());
//		updDoc.setZipcode2(doctor.getZipcode2());
//		updDoc.setExperience(doctor.getExperience());
//		updDoc.setCertification(doctor.getCertification());
//		updDoc.setEducation(doctor.getEducation());
		ses.update(doctor);
		ses.flush();
		ses.evict(doctor);
		tx.commit();
		//ses.close();
		
		} catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return doctor;
	}
	
	// DoctorsByCondition
	
	// DoctorsBySpecialty
	
	public Doctor selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Doctor myDir = ses.get(Doctor.class, id);
		return myDir;
	}
	
	public List<Doctor> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Doctor> dirList = ses.createQuery("from Doctor").list();
		return dirList;
	}

	public Doctor selectByUsernameAndPassword(String un, String pw) {
		Session ses = HibernateUtil.getSession();
		List<Doctor> dList = ses.createCriteria(Doctor.class) .add(Restrictions.like("userName", un)).add(Restrictions.like("passWord", pw)).list();
		if (dList.isEmpty()) {
			return null;
		}
		else {
			return dList.get(0);
		}
	}
	
}
