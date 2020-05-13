package com.benali.controllers;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class ActivemqController {
	
//	@Autowired
//	private Queue queue;
//	
//	@Autowired
//	private JmsTemplate jmsTemplate;
//	
//	@GetMapping("/{message}")
//	public String publish(@PathVariable("message") String message, Model model){
//		
//		jmsTemplate.convertAndSend(queue, message);
//		
//		System.err.println("le message est " + message);
//				
//		return message;
//	}

}
