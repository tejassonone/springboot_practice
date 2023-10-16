package com.abhi.studentapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.abhi.studentapp.dao.StudentRepository;
import com.abhi.studentapp.model.Student;

@Service
public class StudentService {
	
	StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	public List<Student> getStudents() {
		return studentRepository.findAll();
	}


	public void addNewStudent(Student student) {
		Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("email already taken...!");
		}
		studentRepository.save(student);
	}


	public void deleteStudent(Long studentid) {
		boolean exists = studentRepository.existsById(studentid);
		if(!exists) {
			throw new IllegalStateException("student with id " + studentid + " does not exists..!");
		}
		studentRepository.deleteById(studentid);
	}


	public void updateStudent(Long id, String name, String email) {
		@SuppressWarnings("deprecation")
		Student student = studentRepository.getById(id);
		student.setName(name);
		student.setEmail(email);
		studentRepository.save(student);
		
	}

}
