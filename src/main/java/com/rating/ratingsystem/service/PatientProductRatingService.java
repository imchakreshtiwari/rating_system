package com.rating.ratingsystem.service;

import com.rating.ratingsystem.entity.PatientProductRating;

public interface PatientProductRatingService {

	public void addRating(PatientProductRating patientProductRating);
	
	public void updateRating(PatientProductRating patientProductRating);
}
