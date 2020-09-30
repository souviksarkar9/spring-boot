package com.example.springdatajpa;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.repoitory.StudentRepository;
import com.example.springdatajpa.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@WebMvcTest
class StudentRestControllerMvcTest {
	
	private static final String CONTEXT_PATH = "/studentapi-dev";

	private static final String STUDENTAPI_URL = "/studentapi-dev/all";
	
	private static final String STUDENTAPI_URL_SAVE = "/studentapi-dev/save";
	
	private static final String STUDENTAPI_URL_UPDATE = "/studentapi-dev/update";
	
	private static final String STUDENTAPI_URL_DELETE = "/studentapi-dev/delete";

	private static final int STUDENT_RESULT = 100;

	private static final String STUDENT_NAME = "qwerty";

	private static final int STUDENT_ID = 200;

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private StudentService studentService;
	
	@MockBean
	private StudentRepository srepo;
	
	@Test
	void testdeleteStudent() throws Exception {
		Student student = buildStudent();
		doNothing().when(studentService).deleteStudentResult(student);
		
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockmvc.perform(delete(STUDENTAPI_URL_DELETE)				
				.contextPath(CONTEXT_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writer.writeValueAsString(student)))
				.andExpect(status().isOk());		
	}
	
	@Test
	void testupdateStudent() throws Exception {
		Student student = buildStudent();
		student.setName("Souvik");
		
		when(studentService.updateStudentResult(any())).thenReturn(student);
		
		//Jackson writer is used to create the json from object
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockmvc.perform(put(STUDENTAPI_URL_UPDATE)				
				.contextPath(CONTEXT_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writer.writeValueAsString(student)))
				.andExpect(status().isOk())
				.andExpect(content().json(writer.writeValueAsString(student)));
	}
	
	@Test
	void testcreateStudent() throws Exception {
		Student student = buildStudent();
		when(studentService.saveStudentResult(any())).thenReturn(student);
		
		//Jackson writer is used to create the json from object
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockmvc.perform(post(STUDENTAPI_URL_SAVE)				
				.contextPath(CONTEXT_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(writer.writeValueAsString(student)))
				.andExpect(status().isOk())
				.andExpect(content().json(writer.writeValueAsString(student)));
	}

	@Test
	void testfindAll() throws Exception {
		Student student = buildStudent();
		List<Student> students = new ArrayList<>();
		students.add(student);
		
		when(studentService.getAllStudentResults()).thenReturn(students);
		
		//Jackson writer is used to create the json from object
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockmvc.perform(get(STUDENTAPI_URL)
				.contextPath(CONTEXT_PATH))
				.andExpect(status().isOk())
				.andExpect(content().json(writer.writeValueAsString(students)));
		
	}

	private Student buildStudent() {
		Student student = new Student();
		student.setId(STUDENT_ID);
		student.setName(STUDENT_NAME);
		student.setResult(STUDENT_RESULT);
		return student;
	}

}
