package com.example.springrestclient.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springrestclient.dto.StudentDto;

@Service
public class StudentService {

	private Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Value("${studentrestapi.services.url}")
	private String routeurl;

	public List<StudentDto> getAllStudentResults() {
		RestTemplate rest = new RestTemplate();
		logger.info("Inside getAllStudentResults ");
		String url = routeurl.concat("all");
		logger.info("url {} " , url);
		return Arrays.asList(rest.getForObject(url, StudentDto[].class));
	}

	public StudentDto getStudentResultById(long id) {
		RestTemplate rest = new RestTemplate();
		logger.info("Inside getStudentResultById ");
		String url = routeurl.concat("studentresult/").concat(String.valueOf(id));
		logger.info("url {} " , url);
		return rest.getForObject(url , StudentDto.class);
	}

	public StudentDto saveStudentResult(StudentDto student) {
		RestTemplate rest = new RestTemplate();
		logger.info("Inside saveStudentResult ");
		String url = routeurl.concat("save");
		logger.info("url {} " , url);
		return  rest.postForObject(url , student, StudentDto.class);
	}

	public void deleteStudentResult(StudentDto student) {
		RestTemplate rest = new RestTemplate();
		logger.info("Inside deleteStudentResult ");
		String url = routeurl.concat("delete");
		logger.info("url {} " , url);
		rest.delete(url, student);		
		logger.info("Deleted " + student.getId());
	}

}
