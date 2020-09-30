package com.example.springrestclient.studentcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestclient.dto.StudentDto;
import com.example.springrestclient.service.StudentService;

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
	public List<StudentDto> getAllStudentResults(){
		logger.info("Student Service Autowiring: {} " , studentService);
		return studentService.getAllStudentResults();
	}
	
	@RequestMapping(value="/studentresult/{id}" ,  method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDto getStudentResultById(@PathVariable("id") long id){
		logger.info("Student Service Autowiring: {} " , studentService);
		return studentService.getStudentResultById(id);
	}
	
	@RequestMapping(value="/save" ,  method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDto saveStudent(@RequestBody StudentDto student){
		return studentService.saveStudentResult(student);
	}
	
	@RequestMapping(value="/update" ,  method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDto updateStudent(@RequestBody StudentDto student){
		return studentService.saveStudentResult(student);
	}
	

}
