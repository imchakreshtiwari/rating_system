package com.rating.ratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.ratingsystem.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{

}
