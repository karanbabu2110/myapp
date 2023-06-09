package com.example.myapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.dto.StudentDTO;
import com.example.myapp.exception.ResourceNotFoundException;
import com.example.myapp.model.Student;
import com.example.myapp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student createStudent(StudentDTO studentDTO) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDTO, student);
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getStudents(Long id) {
		if (id != null) {
			Optional<Student> optionalStudent = studentRepository.findById(id);
			Student student = optionalStudent
					.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
			return Collections.singletonList(student);
		} else {
			List<Student> students = new ArrayList<>();
			studentRepository.findAll().forEach(students::add);
			return students;
		}
	}

	@Override
	public Student updateStudent(Long id, StudentDTO studentDTO) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student existingStudent = optionalStudent
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
		BeanUtils.copyProperties(studentDTO, existingStudent, "id");
		Student updatedStudent = studentRepository.save(existingStudent);
		return updatedStudent;
	}

	@Override
	public String deleteStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isEmpty()) {
			throw new ResourceNotFoundException("Student not found with id: " + id);
		}
		Student student = optionalStudent.get();
		studentRepository.delete(student);
		return "Student with id " + id + " has been deleted.";
	}
}
