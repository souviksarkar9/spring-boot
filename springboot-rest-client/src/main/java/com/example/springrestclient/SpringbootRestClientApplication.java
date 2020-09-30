package com.example.springrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

//this will disable the DataSourceAutoConfiguration.class to be auto-configured at run time
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

public class SpringbootRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestClientApplication.class, args);
	}

}
