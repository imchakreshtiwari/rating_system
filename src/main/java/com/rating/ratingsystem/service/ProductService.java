package com.rating.ratingsystem.service;

import java.util.List;

import com.rating.ratingsystem.dto.ProductDto;
import com.rating.ratingsystem.entity.Product;

public interface ProductService {

	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public List<ProductDto> getAllProducts();
}
