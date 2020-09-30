package com.example.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.repoitory.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDataJpaApplicationTests {
	
	@Autowired
	private StudentRepository repo;

	@Test
	void testSave() {
		
		Student s = new Student();
		s.setName("souvik");
		s.setResult(100);
		
		Student s2 = repo.save(s);
		
		assertEquals(s.getName() , s2.getName());
		
		assertEquals(s.getId() , repo.findById(s2.getId()).get().getId());
		
	}

}
