package com.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

//this will disable the DataSourceAutoConfiguration.class to be auto-configured at run time
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

@EnableCaching
@EnableSwagger2
public class SpringbootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}

}
