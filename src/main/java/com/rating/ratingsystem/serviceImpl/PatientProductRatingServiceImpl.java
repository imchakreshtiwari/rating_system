package com.rating.ratingsystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingsystem.entity.PatientProductRating;
import com.rating.ratingsystem.entity.Product;
import com.rating.ratingsystem.exception.RecordNotFoundException;
import com.rating.ratingsystem.repository.PatientProductRatingRepo;
import com.rating.ratingsystem.service.PatientProductRatingService;
import com.rating.ratingsystem.service.ProductService;

@Service
public class PatientProductRatingServiceImpl implements PatientProductRatingService{

	@Autowired
	private PatientProductRatingRepo patientProductRatingRepo;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public void addRating(PatientProductRating patientProductRating) {
		
		patientProductRatingRepo.save(patientProductRating);
		//update product table also
		Product productObj = new Product();
		productObj.setId(patientProductRating.getProduct().getId());
		Long count = getRatingCount(patientProductRating.getProduct().getId());
		productObj.setRatingCount(count);
		Long avgRating = getRatingAvg(patientProductRating.getProduct().getId());
		productObj.setAverageRating(avgRating);
		productService.updateProduct(productObj);
	}
	
	@Override
	public void updateRating(PatientProductRating patientProductRating) {
		
		PatientProductRating patientProductRatingFromDb = patientProductRatingRepo.findById(patientProductRating.getId()).orElseThrow(() -> new RecordNotFoundException("Rating not Found"));
		patientProductRatingFromDb.setProductReview(patientProductRating.getProductReview());
		patientProductRatingFromDb.setStarRating(patientProductRating.getStarRating());
		PatientProductRating ratingObj = patientProductRatingRepo.save(patientProductRatingFromDb);
		
		//update product table also
		Product productObj = new Product();
		productObj.setId(ratingObj.getProduct().getId());
		Long count = getRatingCount(ratingObj.getProduct().getId());
		productObj.setRatingCount(count);
		Long avgRating = getRatingAvg(ratingObj.getProduct().getId());
		productObj.setAverageRating(avgRating);
		productService.updateProduct(productObj);
	}
	
	public Long getRatingCount(Long productId){
		Long count = patientProductRatingRepo.getRatingCount(productId);
		if (count == null) {
			return (long) 1;
		}
		return count;
	}
	
	public Long getRatingAvg(Long productId){
		Long avg = patientProductRatingRepo.getRatingAvg(productId);
		if (avg == null) {
			return (long) 1;
		}
		return avg;
	}
}
