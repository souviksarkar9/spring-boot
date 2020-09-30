package com.example.springdatajpa;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ItemReader implements org.springframework.batch.item.ItemReader<String> {

	private String []courses = {"course 1","course 2","course 3"}; 
	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside Read Method");
		if(count < courses.length) {
			return courses[count++];
		}else {
			count = 0;
		}
		return null;
	}

}
