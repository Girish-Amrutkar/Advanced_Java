package com.jspiders.hibernatejpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernatejpa.DTO.StudentDTO;

public class StudentDAO6 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {

		//Getting custom records from the table.
		openConnection();
		entityTransaction.begin();
		
		List<StudentDTO> students = findAll();
		for(StudentDTO student: students) {
			System.out.println(student);
		}
		
		entityTransaction.commit();
		closeConnection();
	}
	
	@SuppressWarnings("unchecked")
	private static List<StudentDTO> findAll() {
		Query query = entityManager.createQuery("SELECT student FROM StudentDTO student WHERE name LIKE '%sh%'");
		List<StudentDTO> students = query.getResultList();
		return students;
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
