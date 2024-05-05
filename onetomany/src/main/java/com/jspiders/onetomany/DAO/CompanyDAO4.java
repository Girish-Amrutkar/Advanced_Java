package com.jspiders.onetomany.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.CompanyDTO;
import com.jspiders.onetomany.DTO.EmployeeDTO;

public class CompanyDAO4 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		//Remove any record from the table.
		
		openConnection();
		entityTransaction.begin();
		
		CompanyDTO company = entityManager.find(CompanyDTO.class, 2);
		List<EmployeeDTO> employees = company.getEmployee();
		EmployeeDTO employeeToBeDeleted = null;
		for(EmployeeDTO employee : employees) {
			if (employee.getId() == 8) {
				employeeToBeDeleted = employee;
				break;
			}
		}
		employees.remove(employeeToBeDeleted);
		company.setEmployee(employees);
		entityManager.persist(company);
		
		entityManager.remove(employeeToBeDeleted);
	
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
