package com.rating.ratingsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingsystem.entity.Patient;
import com.rating.ratingsystem.exception.RecordNotFoundException;
import com.rating.ratingsystem.repository.PatientRepo;
import com.rating.ratingsystem.service.PatientService;

@Service
public class PatientServiceImpl  implements PatientService{

	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public void addPatient(Patient patient) {
	
		patientRepo.save(patient);
	}
	
	@Override
	public void updatePatient(Patient patient) {
	
		Patient patientObj = patientRepo.findById(patient.getId()).orElseThrow(() ->  new RecordNotFoundException("No Patient Found"));
		
		patientObj.setPatientname(patient.getPatientname());
		patientObj.setProducts(patient.getProducts());
		patientRepo.save(patientObj);
	}
	
}
