package com.jspiders.onetomany.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.CompanyDTO;

public class CompanyDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		//Remove the selected record from dependent table
		
		openConnection();
		entityTransaction.begin();
		
		CompanyDTO company = entityManager.find(CompanyDTO.class, 1);
		entityManager.remove(company);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("company");
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
