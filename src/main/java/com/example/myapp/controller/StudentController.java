package com.example.myapp.controller;

import com.example.myapp.dto.StudentDTO;
import com.example.myapp.model.Student;
import com.example.myapp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/new")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents(@RequestParam(value = "id", required = false) Long id) {
		return ResponseEntity.ok(studentService.getStudents(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,
			@Valid @RequestBody StudentDTO studentDTO) {
		return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") Long id) {

		return ResponseEntity.ok(studentService.deleteStudent(id));
	}
}
