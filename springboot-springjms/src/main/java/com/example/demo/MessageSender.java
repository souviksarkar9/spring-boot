package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmstemplate;
	
	@Value("${springjms.myqueue}")
	private String queue;
	
	public void send(String message) {
		System.out.println("Message Sent " + message);
		jmstemplate.convertAndSend(queue, message);
	}
	

}
