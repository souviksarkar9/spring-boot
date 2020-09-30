package com.example.springdatajpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springrestclient.dto.StudentDto;
import com.example.springrestclient.service.StudentService;



@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = StudentService.class)
class SpringbootRestClientApplicationTests {
	
	@Autowired
	private StudentService ss;

	@Test
	void testData() {
		
		assertEquals("souvik" , ss.getStudentResultById(7).getName() );
		
	}
	
	@Test
	void testSave() {
		
		StudentDto s = new StudentDto();
		s.setName("Sanu");
		s.setResult(66);
		
		StudentDto s2 = ss.saveStudentResult(s);
		
		assertEquals(s2.getId() , ss.getStudentResultById(s2.getId()).getId());
		
	}
	
	@Test
	void testDelete() {
		
		List<StudentDto> s2 = ss.getAllStudentResults();
		StudentDto s = s2.get(0);
		ss.deleteStudentResult(s2.get(0));
		assertNotNull( ss.getStudentResultById(s.getId()).getId());
		
	}

}
