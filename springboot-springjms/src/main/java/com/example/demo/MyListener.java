package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

	@JmsListener(destination = "${springjms.myqueue}")
	public void receive(String message) {
		System.out.println("Message Received " + message);
	}

}
