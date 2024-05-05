package com.jspiders.studentmgmt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.studentmgmt.dto.StudentDTO;
import com.jspiders.studentmgmt.dto.TeacherDTO;

public class StudentDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	public void closeConnection() {
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public StudentDTO addStudent(StudentDTO studentDTO) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(studentDTO);
		entityTransaction.commit();
		closeConnection();
		return studentDTO;
	}
	
	public List<StudentDTO> findAllStudents(){
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM StudentDTO student");
		@SuppressWarnings("unchecked")
		List<StudentDTO> students = query.getResultList();
		closeConnection();
		return students;
	}
	
	public List<StudentDTO> findAllStudentsByClass(int id){
		openConnection();
		TeacherDTO teacher = entityManager.find(TeacherDTO.class, id);
		List<StudentDTO> students = teacher.getStudents();
		closeConnection();
		return students;
	}
	
	public void deleteStudent(int teacherId, int studentId) {
		openConnection();
		TeacherDTO teacher = entityManager.find(TeacherDTO.class, teacherId);
		List<StudentDTO> students = teacher.getStudents();
		StudentDTO studentToBeDeleted = null;
		for(StudentDTO student : students) {
			if (student.getId() == studentId) {
				studentToBeDeleted = student;
				break;
			}
		}
		students.remove(studentToBeDeleted);
		teacher.setStudents(students);
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		StudentDTO student = entityManager.find(StudentDTO.class, studentId);
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		closeConnection();
	}
	
	public void updateStudent(StudentDTO student) {
		openConnection();
		StudentDTO studentToBeUpdated = entityManager.find(StudentDTO.class, student.getId());
		studentToBeUpdated.setName(student.getName());
		studentToBeUpdated.setEmail(student.getEmail());
		studentToBeUpdated.setMobile(student.getMobile());
		studentToBeUpdated.setGender(student.getGender());
		entityTransaction.begin();
		entityManager.persist(studentToBeUpdated);
		entityTransaction.commit();
		closeConnection();
	}
	
	public StudentDTO findStudentById(int id) {
		openConnection();
		StudentDTO student = entityManager.find(StudentDTO.class, id);
		closeConnection();
		return student;
	}
	
	
}
