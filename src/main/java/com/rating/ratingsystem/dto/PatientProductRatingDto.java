package com.rating.ratingsystem.dto;

import lombok.Data;

@Data
public class PatientProductRatingDto {

	private long id;
	private String productReview;

	private PatientDto patient;

	private ProductDto product;

	private Integer starRating;
}
