package com.example.springdatajpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long resultid;
	
    @OneToOne(mappedBy = "result")
    @JsonIgnore
    private Student student;
	
	@Max(value=100 , message="marks cannot be greater than 100")
	@Min(value=0 , message="marks cannot be less than 0")
	Long maths;
	
	@Max(value=100 , message="marks cannot be greater than 100")
	@Min(value=0 , message="marks cannot be less than 0")
	Long science;
	
	@Max(value=100 , message="marks cannot be greater than 100")
	@Min(value=0 , message="marks cannot be less than 0")
	Long english;
	
	@Max(value=300 , message="marks cannot be greater than sum of total subjects")
	@Min(value=0 , message="marks cannot be less than 0")
	Long total;

	public long getResultid() {
		return resultid;
	}

	public void setResultid(long resultid) {
		this.resultid = resultid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getMaths() {
		return maths;
	}

	public void setMaths(Long maths) {
		this.maths = maths;
	}

	public Long getScience() {
		return science;
	}

	public void setScience(Long science) {
		this.science = science;
	}

	public Long getEnglish() {
		return english;
	}

	public void setEnglish(Long english) {
		this.english = english;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
}
