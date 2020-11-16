package com.rating.ratingsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingsystem.dto.ProductDto;
import com.rating.ratingsystem.entity.Product;
import com.rating.ratingsystem.exception.RecordNotFoundException;
import com.rating.ratingsystem.repository.ProductRepo;
import com.rating.ratingsystem.service.ProductService;

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
	public List<Product> getAllProducts(){
		
		List<Product> products = productRepo.findAll();
		return products;
	}
}
