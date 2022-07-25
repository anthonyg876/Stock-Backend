package com.example.stockbackend.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class StudentService {

    
	public List<Student> getStudents() {
		return List.of(new Student(5L, "Anthony", "a@gmail.com", LocalDate.of(2000, Month.of(11), 17), 21)); 
	}
}
