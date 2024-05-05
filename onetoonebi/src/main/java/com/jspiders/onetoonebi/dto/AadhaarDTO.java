package com.jspiders.onetoonebi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "aadhaar")
public class AadhaarDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private long aadhaarNumber;
	@OneToOne(mappedBy = "aadhaar")
	private PersonDTO person;
	
}
