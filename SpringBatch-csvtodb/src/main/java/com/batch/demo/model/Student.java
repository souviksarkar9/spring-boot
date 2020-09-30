package com.batch.demo.model;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	long id;
	String name;
	int result;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
	
	

}
