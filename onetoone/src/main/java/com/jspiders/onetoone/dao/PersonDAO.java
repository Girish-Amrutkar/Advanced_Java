package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AadhaarCardDTO;
import com.jspiders.onetoone.dto.PersonDTO;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		PersonDTO personDTO = new PersonDTO();
		personDTO.setName("Girish");
		personDTO.setEmail("girishamrutkar6@gmail.com");
		personDTO.setMobile(8007827353l);
		personDTO.setAge(24);
		
		AadhaarCardDTO aadhaarCardDTO = new AadhaarCardDTO();
		aadhaarCardDTO.setAadhaarNumber(1);
		
		personDTO.setAadhaarCardDTO(aadhaarCardDTO);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(aadhaarCardDTO);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(personDTO);
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
