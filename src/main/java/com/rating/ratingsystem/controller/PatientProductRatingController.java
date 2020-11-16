package com.rating.ratingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.ratingsystem.entity.PatientProductRating;
import com.rating.ratingsystem.service.PatientProductRatingService;

@RestController
@RequestMapping("/rest")
public class PatientProductRatingController {

	@Autowired
	private PatientProductRatingService patientProductRatingService;
	
	@PostMapping(value = "/rating")
	public void addRating(@RequestBody PatientProductRating patientProductRating) {
		
		patientProductRatingService.addRating(patientProductRating);
		
	}
	
	@PutMapping(value = "/rating")
	public void updateRating(@RequestBody PatientProductRating patientProductRating) {
		
		patientProductRatingService.updateRating(patientProductRating);
		
	}
}
