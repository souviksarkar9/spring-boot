package com.example.springdatajpa;

public class ItemProcessor implements org.springframework.batch.item.ItemProcessor<String, String> {
	
	

	@Override
	public String process(String item) throws Exception {
		System.out.println("Inside Process");
		return "PROCESSED " + item.toUpperCase();
	}

}
