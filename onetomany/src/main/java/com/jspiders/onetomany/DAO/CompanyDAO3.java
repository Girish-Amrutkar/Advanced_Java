package com.jspiders.onetomany.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.DTO.CompanyDTO;
import com.jspiders.onetomany.DTO.EmployeeDTO;

public class CompanyDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
	
		//
		
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setName("TATA");
		companyDTO.setLocation("Pune");
		
		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setName("Girish");
		employee1.setEmail("girishamrutkar6@gmail.com");
		employee1.setMobile(8007827353l);
		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setName("Rushikesh");
		employee2.setEmail("rushikeshkhor1@gmail.com");
		employee2.setMobile(9588442280l);
		EmployeeDTO employee3 = new EmployeeDTO();
		employee3.setName("Anuj");
		employee3.setEmail("amrutkaranuj@gmail.com");
		employee3.setMobile(9423712966l);
		EmployeeDTO employee4 = new EmployeeDTO();
		employee4.setName("Krushna");
		employee4.setEmail("krushnaamrutkar2004@gmail.com");
		employee4.setMobile(9422886687l);
		
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		
		companyDTO.setEmployee(employees);
		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(companyDTO);		
		
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
