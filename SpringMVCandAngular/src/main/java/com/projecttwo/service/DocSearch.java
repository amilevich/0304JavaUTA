package com.projecttwo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.Unit;
import com.projecttwo.model.Condition;
import com.projecttwo.model.Doctor;
import com.projecttwo.model.Procedure;
import com.projecttwo.model.Specialty;
import com.projecttwo.repository.ConditionDao;
import com.projecttwo.repository.DoctorDao;
import com.projecttwo.repository.ProcedureDao;
import com.projecttwo.repository.SpecialtyDao;

@Service
public class DocSearch {
	
	@Autowired
	SpecialtyDao sDao;
	@Autowired
	ProcedureDao procDao;
	@Autowired
	ConditionDao condDao;
	
	public List<String> getDriveDist(String addrOrg, String[] addrDes) throws ApiException, InterruptedException, IOException{
		
		List<String> distList = new ArrayList<>();
		//set up key
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyAfkqpU8t3OHmpyKv3TFCe0UuzjEsXjC9I")
			    .build();
	   	
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins(addrOrg)
	               .destinations(addrDes)
	               .units(Unit.IMPERIAL)
	               .language("en-US")
	               .await();
	       
	       for(int i=0;i<addrDes.length; i++) {
				distList.add(result.rows[0].elements[i].distance.humanReadable);
	       }
		
		return distList;
	}
	
	public List<Specialty> selectAllSpecialties() {
		return sDao.selectAll();
	}

	public List<Condition> selectAllConditions() {
		return condDao.selectAllConditions();
	}

	public List<Procedure> selectAllProcedures() {
		return procDao.selectAllProcedures();
	}


}