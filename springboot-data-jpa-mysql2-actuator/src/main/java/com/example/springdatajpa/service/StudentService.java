package com.example.springdatajpa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.repoitory.StudentRepository;

@Service
public class StudentService {
	
	private Logger logger  = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepository srepo;
	
	public List<Student> getAllStudentResults(){
		logger.info("Inside getAllStudents");
		return srepo.findAll();
	}
	
	public Student saveStudentResult(Student s){
		logger.info("Inside Save");
		return srepo.save(s);
	}

	public Student getStudentResultById(long id) {
		logger.info("Inside getStudentResultById");
		return srepo.findById(id).filter(student -> student != null).get();
	}

	public Student updateStudentResult(Student student) {		
		logger.info("Inside updateStudentResult");
		return srepo.save(student);
	}

	public void deleteStudentResult(Student student) {
		logger.info("Inside deleteStudentResult");
		srepo.delete(student);
	}
	

}
