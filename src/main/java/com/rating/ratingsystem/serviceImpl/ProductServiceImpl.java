package com.rating.ratingsystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingsystem.dto.PatientProductRatingDto;
import com.rating.ratingsystem.dto.ProductDto;
import com.rating.ratingsystem.entity.PatientProductRating;
import com.rating.ratingsystem.entity.Product;
import com.rating.ratingsystem.exception.RecordNotFoundException;
import com.rating.ratingsystem.repository.ProductRepo;
import com.rating.ratingsystem.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void addProduct(Product product) {
		
		productRepo.save(product);
	}
	
	@Override
	public void updateProduct(Product product) {
		
		Product productObj = productRepo.findById(product.getId()).orElseThrow(() -> new RecordNotFoundException("No product found"));
		productObj.setAverageRating(product.getAverageRating());
		productObj.setRatingCount(product.getRatingCount());
		
		productRepo.save(productObj);
	}
	
	@Override
	public List<ProductDto> getAllProducts(){
		
		List<ProductDto> productDtos = new ArrayList<>();
		
		List<Product> products = productRepo.findAll();
		log.info("Total products  from db : {}",products.size());
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setProductName(product.getProductName());
			productDto.setProductCategory(product.getProductCategory());
			
			List<PatientProductRating> patientProducts = product.getPatientProductRating();
			List<PatientProductRatingDto> patientProductRatingDtos = new ArrayList<>();
			for (PatientProductRating patientProductRating : patientProducts) {
				PatientProductRatingDto patientProductRatingDto = new PatientProductRatingDto();
				patientProductRatingDto.setId(patientProductRating.getId());
				patientProductRatingDto.setProductReview(patientProductRating.getProductReview());
				patientProductRatingDto.setStarRating(patientProductRating.getStarRating());
				patientProductRatingDtos.add(patientProductRatingDto);
			}
			productDto.setPatientProductRatingDtos(patientProductRatingDtos);
			productDtos.add(productDto);
		}
		return productDtos;
	}
}
