package com.rating.ratingsystem.dto;

import lombok.Data;

@Data
public class ProductDto {

	private long id;

	private String productName;
	private String productCategory;
	
	private Long totalCounts;
	private Long averageRating;

}
