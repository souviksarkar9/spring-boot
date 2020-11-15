package com.example.springdatajpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdatajpa.model.Result;
import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.repoitory.StudentRepository;
import com.example.springdatajpa.service.StudentService;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDataJpaApplicationTests {
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private StudentService studentService;

	@Test
	void testSave() {
		
		Student s = new Student();
		//s.setId(100);
		s.setName("souvik");
		
		Result result = new Result();
		
		result.setEnglish(80L);
		result.setMaths(70L);
		result.setScience(85L);
		result.setTotal(result.getEnglish()+result.getMaths()+result.getScience());
		s.setResult(result);
		
		Student s2 = repo.save(s);
		
		assertEquals(s.getName() , s2.getName());
		assertNotNull(s2);
		
		assertNotNull(repo.findById(s2.getId()));
		
		
	}
	
	@Test
	void testCache() {
		
		List<Student> studentlist = null;
		
		studentlist = studentService.getAllStudentResults();
				
		assertNotNull(studentlist);
		
		
	}

}
