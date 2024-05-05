package com.jspiders.hibernatejpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatejpa.DTO.StudentDTO;

public class StudentDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		//Updating the record present inside the database.
		openConnection();
		entityTransaction.begin();
		
		StudentDTO student = entityManager.find(StudentDTO.class, 2);
		student.setMobile(9588442281l);
		entityManager.persist(student);
		
		
		
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
