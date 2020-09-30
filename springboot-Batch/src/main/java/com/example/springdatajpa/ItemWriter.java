package com.example.springdatajpa;

import java.util.List;

public class ItemWriter implements org.springframework.batch.item.ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("Inside Write");
		System.out.println("Writing Items " + items);
		
	}

}
