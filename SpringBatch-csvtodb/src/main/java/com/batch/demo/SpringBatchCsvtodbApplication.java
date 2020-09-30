package com.batch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchCsvtodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchCsvtodbApplication.class, args);
	}

}
