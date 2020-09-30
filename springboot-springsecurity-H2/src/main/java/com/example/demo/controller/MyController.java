package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Data;
import com.example.demo.service.DataService;


@RestController
public class MyController {
	
	Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private DataService dataservice;
	
	@Autowired
	private UserDetailsService userService;
	
			
	@Secured("ROLE_GUEST")
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> Hi() {
		return new ResponseEntity<>("test application success", HttpStatus.OK);		
	}
	
	@Secured({"ROLE_USER" , "ROLE_GUEST" })
	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public List<Data> getData() {
		logger.info("Inside MyController Class :: getData ");
		return dataservice.getAllData();
		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/setData", method = RequestMethod.GET)	
	public Data setData(@RequestBody Data data) {
		logger.info("Inside MyController Class :: setData");
		return dataservice.saveDataResult(data);
		
	}
	
	@RequestMapping(value = "/guest/welcome", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> welcomeUser() {
		return new ResponseEntity<>("Hello User, Welcome", HttpStatus.OK);		
	}
	
}
