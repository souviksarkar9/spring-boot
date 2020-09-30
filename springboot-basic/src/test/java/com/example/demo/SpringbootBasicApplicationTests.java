package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.MyController;
import com.example.demo.service.PaymentService;
import com.example.demo.service.impl.PaymentServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootBasicApplicationTests {
	
	@Autowired
	PaymentService 	paymentService;
	
	@Autowired
	PaymentServiceImpl 	paymentServiceImpl;
	
	@Mock
	MyController myc;
	

	@Test
	void testDI() {
		assertNotNull(paymentService);
		assertNotNull(paymentServiceImpl.getPaymentDao());
		assertNull(myc.getPaymentServiceImpl());

	}

}
