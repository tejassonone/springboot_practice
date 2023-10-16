package com.abhi.studentapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.studentapp.model.Student;

@RestController
@RequestMapping("api")
public class SecurityController {
	
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "krutika"),
			new Student(2, "parth"),
			new Student(3, "anuja")
			);
	
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("student " + studentId + " does not exist"));
	}
	
	@GetMapping("admin")
	public String getApi() {
		return "api : admin";
	}
	
	@GetMapping("user")
	public String getUser() {
		return "user : user, admin";
	}
}
