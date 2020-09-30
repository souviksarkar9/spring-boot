package com.example.springdatajpa.model;

public class Student {
	
	String name;
	long res;
	
	
	public Student(String name, long res) {
		super();
		this.name = name;
		this.res = res;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getRes() {
		return res;
	}
	public void setRes(long res) {
		this.res = res;
	}
	
	

}
