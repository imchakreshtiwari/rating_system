package com.rating.ratingsystem.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class PatientDto {

	private long id;

	private String patientname;

	private Set<ProductDto> products = new HashSet<>();

	private List<PatientProductRatingDto> patientProductRating = new ArrayList<>();
}
