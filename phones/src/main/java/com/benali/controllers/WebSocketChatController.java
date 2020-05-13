package com.benali.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.benali.WebSocketChatMessage;

@Controller
public class WebSocketChatController {
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/benali")
	public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage webSocketMessage) {
		return webSocketMessage;
	}
	
	@MessageMapping("/chat.newUser")
	@SendTo("/topic/benali")
	public WebSocketChatMessage newUser(@Payload WebSocketChatMessage webSocketMessage, 
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", webSocketMessage.getSender());
		return webSocketMessage;
	}

}
