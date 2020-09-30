package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSpringjmsApplicationTests {
	
	@Autowired
	private MessageSender sender; 	

	@Test
	void testSendReceive() {
		sender.send("Hello Spring JMS");
	}

}
