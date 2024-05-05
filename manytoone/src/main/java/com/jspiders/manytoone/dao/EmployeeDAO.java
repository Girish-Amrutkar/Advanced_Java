package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.CompanyDTO;
import com.jspiders.manytoone.dto.EmployeeDTO;


public class EmployeeDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		//Adding records in the table
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName("Ashutosh");
		employee.setEmail("ashutoshsinha@gmail.com");
		employee.setMobile(7545497656l);
		
		CompanyDTO company = new CompanyDTO();
		company.setName("Tata");
		company.setLocation("Pune");
		
		employee.setCompany(company);
		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(company);
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
