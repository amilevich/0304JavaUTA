package com.projecttwo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.projecttwo.model.Condition;
import com.projecttwo.model.Doctor;
import com.projecttwo.model.Patient;
import com.projecttwo.model.Procedure;
import com.projecttwo.model.SearchResults;
import com.projecttwo.model.Specialty;
import com.projecttwo.repository.DoctorDao;
import com.projecttwo.service.DocSearch;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SearchCtrl {

	@Autowired
	DocSearch dSearch;
	
	@RequestMapping(value="/getdoctorsbylocation", method = RequestMethod.GET, params = { "origin", "conditionId", "procedureId", "specialtyId" })
	public List<SearchResults> getDriveDist(String origin) {
		List<String> distance = new ArrayList<>();
		List<String> addrDest = new ArrayList<>();
		List<SearchResults> searchResults = new ArrayList<>();
		DoctorDao dDao = new DoctorDao();
		
		
		List<Doctor> dList = dDao.selectAll();
		
		// only get up to 15 items
		int maxItems = 150;
		int counter = 0;
		// get list of doctors by Condition
		for(Doctor d: dList) {
			try {
//			if (d.getDoctorId() == 181) {
//				System.out.println("doc ock loaded");
//			}
			counter++;
			addrDest.add(d.getStreet()+","+ d.getState());
			SearchResults searchResult = new SearchResults();
			searchResult.setDoctorId(d.getDoctorId());
			searchResult.setFirstName(d.getFirstName());
			searchResult.setLastName(d.getLastName());
			searchResult.setAddress(d.getStreet() + " " + d.getCity() + ", " + d.getState() + " "+ d.getZipcode());
			
			// check for specialty
			if (d.getSpecialties().size() > 0)
			{
				Specialty spec = d.getSpecialties().get(0);
				searchResult.setSpecialty(spec.getSpecialty());
			}
			if (d.getPhone() != null) {
				searchResult.setPhoneNo(d.getPhone().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
			}
			searchResult.setProfilePic(d.getProfilepic());
			//searchResult.setInsurance(d.getInsurances().get(0).toString());
			searchResults.add(searchResult);
			if (counter > maxItems)
				break;
			}
			catch (Exception ex) {
				System.out.println("error");
			}
		}
		String[] addrDes = addrDest.toArray(new String[addrDest.size()]);
		
		
		try {
			distance = dSearch.getDriveDist(origin, addrDes);
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// add the mileage to the results
		SearchResults searchElement;
		String searchDistance;
		for (int i = 0; i < searchResults.size(); i ++)
		{

			searchElement = searchResults.get(i);
//			if (searchElement.getDoctorId() == 181) {
//				System.out.println("doc ock loaded");
//			}
			searchDistance = distance.get(i);
			searchElement.setDistanceString(searchDistance);
			try
			{
				searchElement.setDistanceValue((int)Double.parseDouble(searchDistance.replace("mi", "").replace(",", "").trim()));
			}
			catch (Exception ex)
			{
				searchElement.setDistanceValue(0);
			}
		}
		
		searchResults.sort(Comparator.comparing(SearchResults::getDistanceValue));
		
		return searchResults;
	}
	
	@RequestMapping(value="/getspecialties", method=RequestMethod.GET)
	public List<Specialty> selectAllSpecialties(){
		return dSearch.selectAllSpecialties();
	}
	
	@RequestMapping(value="/getprocedures", method=RequestMethod.GET)
	public List<Procedure> selectAllProcedures(){
		return dSearch.selectAllProcedures();
	}
	
	@RequestMapping(value="/getconditions", method=RequestMethod.GET)
	public List<Condition> selectAllConditions(){
		return dSearch.selectAllConditions();
	}
	
//	@RequestMapping(value="/getdoctorsbyspecialty", method=RequestMethod.GET)
//	public List<Doctor> getAllPatients(){
//		return dSearch.getAllPatients();
//	}
	
}