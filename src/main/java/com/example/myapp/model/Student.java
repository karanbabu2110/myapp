package com.example.myapp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Date of Birth is required")
	private String dob;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotBlank(message = "Department is required")
	private String department;

	@Min(value=0, message = "Year of Application is required")
	private int yearOfApply;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfApply() {
		return yearOfApply;
	}

	public void setYearOfApply(int yearOfApply) {
		this.yearOfApply = yearOfApply;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(Long id, String name, String dob, String gender, String department, int yearOfApply,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.department = department;
		this.yearOfApply = yearOfApply;
		this.email = email;
	}
}
