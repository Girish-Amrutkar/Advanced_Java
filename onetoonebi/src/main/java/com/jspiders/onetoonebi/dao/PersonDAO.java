package com.jspiders.onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebi.dto.AadhaarDTO;
import com.jspiders.onetoonebi.dto.PersonDTO;

public class PersonDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		PersonDTO person = new PersonDTO();
		person.setName("Aman");
		person.setEmail("amansikalgar@gmail.com");
		person.setMobile(8830712373l);
		
		AadhaarDTO aadhaar = new AadhaarDTO();
		aadhaar.setAadhaarNumber(835812113610l);
		
		person.setAadhaar(aadhaar);
		aadhaar.setPerson(person);
		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(aadhaar);
		entityManager.persist(person);
		
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
