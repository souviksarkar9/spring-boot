package com.example.springdatajpa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Entity
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotNull
	@Size(max = 30)
	@Size(min = 2)
	String name;
	
//	@Max(value=100 , message="marks cannot be greater than 100")
//	@Min(value=0 , message="marks cannot be less than 0")
//	int result;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id", referencedColumnName = "resultid")
    private Result result;
	
	
	
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
//	public int getResult() {
//		return result;
//	}
//	public void setResult(int result) {
//		this.result = result;
//	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", result=" + result + "]";
	}
	
	
	
	

}
