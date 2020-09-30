package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
	Logger logger = LoggerFactory.getLogger(MyController.class);
	
	List<String> data = new ArrayList<>(Arrays.asList("Choice 1","Choice 2","Choice 3"));
			
	@Secured("ROLE_GUEST")
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> Hi() {
		return new ResponseEntity<>("test application success", HttpStatus.OK);		
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<String>> getData() {
		logger.info("Inside MyController Class :: getData ");
		return new ResponseEntity<>(data, HttpStatus.OK);
		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/setData", method = RequestMethod.GET)	
	public ResponseEntity<List<String>> setData(@RequestParam String inpdata) {
		logger.info("Inside MyController Class :: setData");
		data.add(inpdata);
		return new ResponseEntity<>(data, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/guest/welcome", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> welcomeUser() {
		return new ResponseEntity<>("Hello User, Welcome", HttpStatus.OK);		
	}
	
}
