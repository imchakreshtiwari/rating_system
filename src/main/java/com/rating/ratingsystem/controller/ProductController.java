package com.rating.ratingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.ratingsystem.entity.Product;
import com.rating.ratingsystem.service.ProductService;

@RestController
@RequestMapping("/rest")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/product")
	public void addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
	}
	
	@PutMapping(value = "/product")
	public void updateProduct(@RequestBody Product product) {
		
		productService.updateProduct(product);
	}
	
	@GetMapping(value = "/product")
	public List<Product> getAllProduct() {
		
		List<Product> products = productService.getAllProducts();
		return products;
	}
}
