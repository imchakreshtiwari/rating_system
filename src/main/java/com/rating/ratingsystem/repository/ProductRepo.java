package com.rating.ratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.ratingsystem.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
