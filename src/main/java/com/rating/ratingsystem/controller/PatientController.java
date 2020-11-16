package com.rating.ratingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.ratingsystem.entity.Patient;
import com.rating.ratingsystem.service.PatientService;

@RestController
@RequestMapping("/rest")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping(value = "/patient")
	public void addPatient(@RequestBody Patient patient) {
		
		patientService.addPatient(patient);
	}
	
	@PutMapping(value = "/patient")
	public void updatePatient(@RequestBody Patient patient) {
		
		patientService.updatePatient(patient);
	}
}
