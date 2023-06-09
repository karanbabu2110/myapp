package com.example.myapp;

import com.example.myapp.dto.StudentDTO;
import com.example.myapp.model.Student;

public class StudentTestData {
	public Student getStudentData() {
		Student student = new Student();
		student.setId(1L);
		student.setName("John");
		student.setGender("Male");
		student.setDob("21-10-1997");
		student.setDepartment("CSE");
		student.setYearOfApply(1997);
		student.setEmail("john1997@gmail.com");
		return student;
	}
	
	public StudentDTO getStudentDTOData() {
		StudentDTO student = new StudentDTO();
		student.setName("John");
		student.setGender("Male");
		student.setDob("21-10-1997");
		student.setDepartment("CSE");
		student.setYearOfApply(1997);
		student.setEmail("john1997@gmail.com");
		return student;
	}
}
