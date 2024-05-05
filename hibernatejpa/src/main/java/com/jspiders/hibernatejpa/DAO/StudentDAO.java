package com.jspiders.hibernatejpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatejpa.DTO.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
	
		//Adding the record inside database.
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(4);
		studentDTO.setName("Rohit");
		studentDTO.setEmail("rohitpatil@gmail.com");
		studentDTO.setMobile(8830867752l);
		studentDTO.setAge(22);
		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(studentDTO);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
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