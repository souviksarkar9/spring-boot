	package com.batch.demo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.batch.demo.model.Student;

@Configuration
public class BatchConfig {
	
	@Autowired
	private StepBuilderFactory sdf;
	
	@Autowired
	private JobBuilderFactory jbf;
	
	@Bean
	public Job job() {
		return jbf.get("Job 1").
				incrementer(new RunIdIncrementer())
				.start(step()).build();
	}
	
	@Bean
	public Step step() {
		return sdf.get("Step 1").<Student , Student>chunk(3)
				.reader(reader())
				.writer(writer())
				.processor(processor())
				.build();
	}
	
	@Bean
	public ItemReader<Student> reader(){
		FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("student.csv"));
		
		DefaultLineMapper<Student> linemapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","name","result");
		
		BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Student.class);
		
		linemapper.setLineTokenizer(lineTokenizer);
		linemapper.setFieldSetMapper(fieldSetMapper);
		
		reader.setLineMapper(linemapper);
		
		
		return reader;		
	}
	
	@Bean
	public ItemProcessor<Student, Student> processor(){		
		return student -> {
			student.setName(student.getName().toUpperCase());
			return student;
		};
	}
	
	@Bean
	public ItemWriter<Student> 	writer(){
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(datasource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Student>());
		writer.setSql("INSERT INTO STUDENT (id,name,result) VALUES (:id , :name , :result) ");
		return writer;
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
		
	}
	
	
}
