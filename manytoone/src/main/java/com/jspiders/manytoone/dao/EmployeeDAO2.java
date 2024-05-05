package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.CompanyDTO;
import com.jspiders.manytoone.dto.EmployeeDTO;

public class EmployeeDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName("Kiran");
		employee.setEmail("kiranjadhav@gmail.com");
		employee.setMobile(7456545565l);
		
		CompanyDTO company = null;
		
		openConnection();
		entityTransaction.begin();
		
		company = entityManager.find(CompanyDTO.class, 1);
		employee.setCompany(company);
		
		entityManager.persist(employee);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
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
