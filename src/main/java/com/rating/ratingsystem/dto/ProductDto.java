package com.rating.ratingsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDto {

	private long id;

	private String productName;
	private String productCategory;
	
	private Long totalCounts;
	private Long averageRating;
	
	private List<PatientProductRatingDto> patientProductRatingDtos;

}
