package com.rating.ratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rating.ratingsystem.entity.PatientProductRating;

@Repository
public interface PatientProductRatingRepo extends JpaRepository<PatientProductRating, Long>{
	
	@Query("select e from PatientProductRating e where e.patient.id =:patientId AND e.product.id =:productId")
	public PatientProductRating findByPatientIdAndProductId(Long patientId, Long productId);
	
	@Query("select count(*) from PatientProductRating e where e.product.id =:productId")
	public Long getRatingCount(Long productId);
	
	@Query("select AVG(e.starRating) from PatientProductRating e where e.product.id =:productId")
	public Long getRatingAvg(Long productId);
}
