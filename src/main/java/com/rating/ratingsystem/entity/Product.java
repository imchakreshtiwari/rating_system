package com.rating.ratingsystem.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Product")
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String productName;
	private String productCategory;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy = "products")
	private Set<Patient> patients = new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<PatientProductRating> patientProductRating = new ArrayList<>();
	
	private Long ratingCount;
	private Long averageRating;
	
	@JsonIgnore
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Calendar createdDate;

	@JsonIgnore
	@UpdateTimestamp
	private Calendar lastModifiedDate;

}
