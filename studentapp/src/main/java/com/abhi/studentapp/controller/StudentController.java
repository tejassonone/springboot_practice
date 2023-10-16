package com.abhi.studentapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.studentapp.model.Student;
import com.abhi.studentapp.service.StudentService;

@RestController
@RequestMapping(path="students")
public class StudentController {
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}


	@GetMapping("")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@PostMapping("")
	public void registerNewStudent(@RequestBody Student student) {
		System.out.println("student data ----> " + student);
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping("{studentid}")
	public void deleteStudent(@PathVariable("studentid") Long studentid) {
		studentService.deleteStudent(studentid);
	}
	
	@PutMapping("{studentid}")
	public void updateStudent(@PathVariable("studentid") Long id, @RequestParam(required=false) String name, @RequestParam(required=false) String email) {
		studentService.updateStudent(id, name, email);
	}

}
