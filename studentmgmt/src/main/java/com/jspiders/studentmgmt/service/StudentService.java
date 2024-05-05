package com.jspiders.studentmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.studentmgmt.dao.StudentDAO;
import com.jspiders.studentmgmt.dto.StudentDTO;
import com.jspiders.studentmgmt.dto.TeacherDTO;

@Component
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public StudentDTO addStudent(String name, String email, String gender, long mobile) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(name);
		studentDTO.setEmail(email);
		studentDTO.setGender(gender);
		studentDTO.setMobile(mobile);
		return studentDAO.addStudent(studentDTO);
	}
	
	public List<StudentDTO> findAllStudents(){
		List<StudentDTO> students = studentDAO.findAllStudents();
		if (students != null && students.size() > 0) {
			return students;
		}else {
			return null;
		}
	}
	
	public List<StudentDTO> findAllStudentsByClass(TeacherDTO signedInTeacher){
		List<StudentDTO> students = studentDAO.findAllStudentsByClass(signedInTeacher.getId());
		if (students != null && students.size() > 0) {
			return students;
		}else {
			return null;
		}
	}
	
	public void deleteStudent(TeacherDTO signedInTeacher, int studentId) {
		studentDAO.deleteStudent(signedInTeacher.getId(), studentId);
	}
	
	public StudentDTO findStudentById(int id) {
		return studentDAO.findStudentById(id);
	}
	
	public void updateStudent(int id, String name, String email, String gender, long mobile) {
		StudentDTO student = new StudentDTO();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setGender(gender);
		student.setMobile(mobile);
		studentDAO.updateStudent(student);
	}
}
