package com.jspiders.studentmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.studentmgmt.dao.TeacherDAO;
import com.jspiders.studentmgmt.dto.StudentDTO;
import com.jspiders.studentmgmt.dto.TeacherDTO;

@Component
public class TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	public TeacherDTO addTeacher(String email, String password) {
		TeacherDTO addedTeacher = null;
		boolean flag = false;
		List<TeacherDTO> teachers = teacherDAO.findAllTeachers();
		for(TeacherDTO teacher : teachers) {
			if (teacher.getEmail().equals(email)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			TeacherDTO teacherDTO = new TeacherDTO();
			teacherDTO.setEmail(email);
			teacherDTO.setPassword(password);
			teacherDTO.setStudents(new ArrayList<StudentDTO>());
			addedTeacher = teacherDAO.addTeacher(teacherDTO);
		}
		return addedTeacher;
	}
	
	public TeacherDTO checkTeacher(String email, String password) {
		List<TeacherDTO> teachers = teacherDAO.findAllTeachers();
		TeacherDTO signedInTeacher = null;
		for(TeacherDTO teacher : teachers) {
			if (teacher.getEmail().equals(email) && teacher.getPassword().equals(password)) {
				signedInTeacher = teacher;
				break;
			}
		}
		return signedInTeacher;
	}
	
	public void deleteTeacher(TeacherDTO signedInTeacher) {
		teacherDAO.deleteTeacher(signedInTeacher.getId());
	}
	
	public void updateTeacher(TeacherDTO signedInTeacher, StudentDTO addedStudent) {
		teacherDAO.updateTeacher(signedInTeacher.getId(), addedStudent.getId());
	}
}
