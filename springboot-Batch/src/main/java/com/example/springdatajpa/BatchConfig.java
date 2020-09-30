package com.example.springdatajpa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
	
	@Bean
	public ItemReader reader() {
		return new ItemReader();
	}
	@Bean
	public ItemProcessor processor() {
		return new ItemProcessor();
	}
	@Bean
	public ItemWriter writer() {
		return new ItemWriter();
	}
	@Bean
	public MyJobListener myjoblistener() {
		return new MyJobListener();
	}
	
	@Autowired
	private StepBuilderFactory sdf;
	
	@Autowired
	private JobBuilderFactory jbf;
	
	@Bean
	public Job job() {
		return jbf.get("Job 1").
				incrementer(new RunIdIncrementer())
				.listener(myjoblistener())
				.start(step()).build();
	}
	
	@Bean
	public Step step() {
		return sdf.get("Step 1").<String , String>chunk(3)
				.reader(reader())
				.writer(writer())
				.processor(processor())
				.build();
	}
	
}
