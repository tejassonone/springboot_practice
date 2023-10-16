package com.abhi.studentapp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abhi.studentapp.model.Student;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args->{
			Student krutika = new Student(
					"krutika", 
					"krutika@gmail.com",
					LocalDate.of(2001, 5, 21)
					);
			
			Student parth = new Student(
					"parth", 
					"parth@gmail.com",
					LocalDate.of(2001, 6, 11)
					);
			
			repository.saveAll(List.of(krutika, parth));
		};
	}
}
