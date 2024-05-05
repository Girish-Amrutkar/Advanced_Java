package com.jspiders.manytomanybi.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomanybi.dto.CourseDTO;
import com.jspiders.manytomanybi.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		StudentDTO student1 = new StudentDTO();
		student1.setName("Mahesh");
		student1.setEmail("maheshdalle@gmail.com");
		student1.setMobile(7646564545l);
		
		StudentDTO student2 = new StudentDTO();
		student2.setName("Babdi");
		student2.setEmail("babdishemdi@gmail.com");
		student2.setMobile(8944646445l);
		
		CourseDTO course1 = new CourseDTO();
		course1.setName("SQL");
		course1.setFees(3000.50);
		
		CourseDTO course2 = new CourseDTO();
		course2.setName("Core Java");
		course2.setFees(7000.80);
		
		CourseDTO course3 = new CourseDTO();
		course3.setName("Web Tech");
		course3.setFees(12000.35);
		
		student1.setCourses(Arrays.asList(course1, course2));
		student2.setCourses(Arrays.asList(course2, course3));

		course1.setStudents(Arrays.asList(student1));
		course2.setStudents(Arrays.asList(student1, student2));
		course3.setStudents(Arrays.asList(student2));

		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		
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
