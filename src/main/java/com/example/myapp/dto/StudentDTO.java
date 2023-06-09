package com.example.myapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class StudentDTO {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Date of Birth is required")
	private String dob;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotBlank(message = "Department is required")
	private String department;

	private int yearOfApply;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

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

	public StudentDTO(String name, String dob, String gender, String department, int yearOfApply, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.department = department;
		this.yearOfApply = yearOfApply;
		this.email = email;
	}

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}