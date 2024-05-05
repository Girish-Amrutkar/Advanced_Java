package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AadhaarCardDTO;
import com.jspiders.onetoone.dto.PersonDTO;

public class PersonDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		PersonDTO person = entityManager.find(PersonDTO.class, 3);
		AadhaarCardDTO aadhaarCard = person.getAadhaarCardDTO();
		
		entityManager.remove(aadhaarCard);
		entityManager.remove(person);
		
		
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
