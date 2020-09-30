package com.example.springdatajpa.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springdatajpa.model.Student;

@RestController
public class myController {
	
	@RequestMapping(value="/hello" , method = RequestMethod.GET )
	public String helloController() {
		return "Hello";
	}
	
	
	@RequestMapping(value="/senddata" , method = RequestMethod.GET )
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Custom Data sent to you");
		return mav;
	}
	
	@RequestMapping(value="/sendstudent" , method = RequestMethod.GET )
	public ModelAndView sendStudent() {
		ModelAndView mav = new ModelAndView("student");
		mav.addObject("student", new Student("Souvik" , 100));
		return mav;
	}
	
	@RequestMapping(value="/sendstudents" , method = RequestMethod.GET )
	public ModelAndView sendStudents() {
		ModelAndView mav = new ModelAndView("studentlist");
		mav.addObject("students", Arrays.asList(new Student("Souvik" , 100), new Student("Souvik Sarkar" , 89), new Student("S.Sarkar" , 70), new Student("Souvik S" , 90)));
		return mav;
	}
	
	@RequestMapping(value="/studentform" , method = RequestMethod.GET )
	public ModelAndView studentForm() {
		ModelAndView mav = new ModelAndView("StudentForm");
		mav.addObject("student", new Student("Souvik" , 100));
		return mav;
	}
	
	@RequestMapping(value="/savestudent" , method = RequestMethod.POST )
	public ModelAndView savestudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("student", student);
		return mav;
	}

}
