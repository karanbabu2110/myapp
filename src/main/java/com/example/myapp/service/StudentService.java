package com.example.myapp.service;

import com.example.myapp.dto.StudentDTO;
import com.example.myapp.model.Student;

import java.util.List;

public interface StudentService {
	Student createStudent(StudentDTO studentDTO);

	List<Student> getStudents(Long id);

	Student updateStudent(Long id, StudentDTO studentDTO);

	String deleteStudent(Long id);
}