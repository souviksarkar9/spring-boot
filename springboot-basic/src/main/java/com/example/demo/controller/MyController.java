package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.impl.PaymentServiceImpl;

import io.swagger.annotations.ApiOperation;


@RestController
public class MyController {
	
	Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	public PaymentServiceImpl getPaymentServiceImpl() {
		return paymentServiceImpl;
	}

	public void setPaymentServiceImpl(PaymentServiceImpl paymentServiceImpl) {
		this.paymentServiceImpl = paymentServiceImpl;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> Hi() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Make Payment through third party",
			notes = "takes input the amoount to be paid", 
			response = ResponseEntity.class,
			produces = "application/json")
	@RequestMapping(value = "/makepayment", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> makePayment(@RequestParam long amount) {
		logger.info("Inside MyController Class");
		String result = paymentServiceImpl.payAmount(amount);
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
}
