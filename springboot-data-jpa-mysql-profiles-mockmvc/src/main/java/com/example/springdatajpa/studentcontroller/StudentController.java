package com.example.springdatajpa.studentcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.service.StudentService;

@RestController
public class StudentController {
	
	private Logger logger  = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}
	
	@RequestMapping(value="/all" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(readOnly = true)
	@Cacheable("student-cache")
	public List<Student> getAllStudentResults(){
		logger.info("Student Service Autowiring: {} " , studentService);
		return studentService.getAllStudentResults();
	}
	
	@RequestMapping(value="/studentresult/{id}" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentResultById(@PathVariable("id") long id){
		logger.info("Student Service Autowiring: {} " , studentService);
		return studentService.getStudentResultById(id);
	}
	
		
	@RequestMapping(value="/save" ,  method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public Student saveStudent(@RequestBody Student student){
		return studentService.saveStudentResult(student);
	}
	
	@RequestMapping(value="/update" ,  method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict(value = "student-cache", key = "#student.id")
	public Student updateStudent(@RequestBody Student student){
		return studentService.updateStudentResult(student);
	}
	
	@RequestMapping(value="/delete" ,  method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict(value = "student-cache", key = "#student.id")
	public ResponseEntity<String> deleteStudent(@RequestBody Student student){
		studentService.deleteStudentResult(student);
		return new ResponseEntity<String>("Deleted "+ student.getId(), HttpStatus.OK);
	}
	

}
